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

import com.entity.GequkuEntity;
import com.entity.view.GequkuView;

import com.service.GequkuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 歌曲库
 * 后端接口
 * @author 
 * @email 
 * @date 2021-02-27 21:18:32
 */
@RestController
@RequestMapping("/gequku")
public class GequkuController {
    @Autowired
    private GequkuService gequkuService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GequkuEntity gequku, HttpServletRequest request){

        EntityWrapper<GequkuEntity> ew = new EntityWrapper<GequkuEntity>();
    	PageUtils page = gequkuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gequku), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GequkuEntity gequku, HttpServletRequest request){
        EntityWrapper<GequkuEntity> ew = new EntityWrapper<GequkuEntity>();
    	PageUtils page = gequkuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gequku), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GequkuEntity gequku){
       	EntityWrapper<GequkuEntity> ew = new EntityWrapper<GequkuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gequku, "gequku")); 
        return R.ok().put("data", gequkuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GequkuEntity gequku){
        EntityWrapper< GequkuEntity> ew = new EntityWrapper< GequkuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gequku, "gequku")); 
		GequkuView gequkuView =  gequkuService.selectView(ew);
		return R.ok("查询歌曲库成功").put("data", gequkuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GequkuEntity gequku = gequkuService.selectById(id);
        return R.ok().put("data", gequku);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GequkuEntity gequku = gequkuService.selectById(id);
        return R.ok().put("data", gequku);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GequkuEntity gequku, HttpServletRequest request){
    	gequku.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gequku);

        gequkuService.insert(gequku);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GequkuEntity gequku, HttpServletRequest request){
    	gequku.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gequku);

        gequkuService.insert(gequku);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GequkuEntity gequku, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gequku);
        gequkuService.updateById(gequku);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gequkuService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<GequkuEntity> wrapper = new EntityWrapper<GequkuEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = gequkuService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	


}
