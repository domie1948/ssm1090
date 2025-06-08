package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.GequleixingEntity;
import com.entity.view.GequleixingView;

import com.service.GequleixingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 歌曲类型
 * 后端接口
 * @author 
 * @email 
 * @date 2021-02-27 21:18:32
 */
@RestController
@RequestMapping("/gequleixing")
public class GequleixingController {
    @Autowired
    private GequleixingService gequleixingService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GequleixingEntity gequleixing, HttpServletRequest request){

        EntityWrapper<GequleixingEntity> ew = new EntityWrapper<GequleixingEntity>();
    	PageUtils page = gequleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gequleixing), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GequleixingEntity gequleixing, HttpServletRequest request){
        EntityWrapper<GequleixingEntity> ew = new EntityWrapper<GequleixingEntity>();
    	PageUtils page = gequleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gequleixing), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GequleixingEntity gequleixing){
       	EntityWrapper<GequleixingEntity> ew = new EntityWrapper<GequleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gequleixing, "gequleixing")); 
        return R.ok().put("data", gequleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GequleixingEntity gequleixing){
        EntityWrapper< GequleixingEntity> ew = new EntityWrapper< GequleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gequleixing, "gequleixing")); 
		GequleixingView gequleixingView =  gequleixingService.selectView(ew);
		return R.ok("查询歌曲类型成功").put("data", gequleixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GequleixingEntity gequleixing = gequleixingService.selectById(id);
        return R.ok().put("data", gequleixing);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GequleixingEntity gequleixing = gequleixingService.selectById(id);
        return R.ok().put("data", gequleixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GequleixingEntity gequleixing, HttpServletRequest request){
    	gequleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gequleixing);

        gequleixingService.insert(gequleixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GequleixingEntity gequleixing, HttpServletRequest request){
    	gequleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gequleixing);

        gequleixingService.insert(gequleixing);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GequleixingEntity gequleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gequleixing);
        gequleixingService.updateById(gequleixing);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gequleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<GequleixingEntity> wrapper = new EntityWrapper<GequleixingEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = gequleixingService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	


}
