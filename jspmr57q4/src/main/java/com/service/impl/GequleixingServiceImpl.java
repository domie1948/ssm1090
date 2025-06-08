package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.GequleixingDao;
import com.entity.GequleixingEntity;
import com.service.GequleixingService;
import com.entity.vo.GequleixingVO;
import com.entity.view.GequleixingView;

@Service("gequleixingService")
public class GequleixingServiceImpl extends ServiceImpl<GequleixingDao, GequleixingEntity> implements GequleixingService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GequleixingEntity> page = this.selectPage(
                new Query<GequleixingEntity>(params).getPage(),
                new EntityWrapper<GequleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GequleixingEntity> wrapper) {
		  Page<GequleixingView> page =new Query<GequleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GequleixingVO> selectListVO(Wrapper<GequleixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GequleixingVO selectVO(Wrapper<GequleixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GequleixingView> selectListView(Wrapper<GequleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GequleixingView selectView(Wrapper<GequleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
