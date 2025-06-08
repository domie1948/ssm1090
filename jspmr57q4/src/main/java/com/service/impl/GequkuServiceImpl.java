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


import com.dao.GequkuDao;
import com.entity.GequkuEntity;
import com.service.GequkuService;
import com.entity.vo.GequkuVO;
import com.entity.view.GequkuView;

@Service("gequkuService")
public class GequkuServiceImpl extends ServiceImpl<GequkuDao, GequkuEntity> implements GequkuService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GequkuEntity> page = this.selectPage(
                new Query<GequkuEntity>(params).getPage(),
                new EntityWrapper<GequkuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GequkuEntity> wrapper) {
		  Page<GequkuView> page =new Query<GequkuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GequkuVO> selectListVO(Wrapper<GequkuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GequkuVO selectVO(Wrapper<GequkuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GequkuView> selectListView(Wrapper<GequkuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GequkuView selectView(Wrapper<GequkuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
