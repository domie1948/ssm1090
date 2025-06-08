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


import com.dao.DiangexinxiDao;
import com.entity.DiangexinxiEntity;
import com.service.DiangexinxiService;
import com.entity.vo.DiangexinxiVO;
import com.entity.view.DiangexinxiView;

@Service("diangexinxiService")
public class DiangexinxiServiceImpl extends ServiceImpl<DiangexinxiDao, DiangexinxiEntity> implements DiangexinxiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiangexinxiEntity> page = this.selectPage(
                new Query<DiangexinxiEntity>(params).getPage(),
                new EntityWrapper<DiangexinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiangexinxiEntity> wrapper) {
		  Page<DiangexinxiView> page =new Query<DiangexinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiangexinxiVO> selectListVO(Wrapper<DiangexinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiangexinxiVO selectVO(Wrapper<DiangexinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiangexinxiView> selectListView(Wrapper<DiangexinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiangexinxiView selectView(Wrapper<DiangexinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
