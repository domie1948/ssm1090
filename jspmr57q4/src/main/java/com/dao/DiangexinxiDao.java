package com.dao;

import com.entity.DiangexinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiangexinxiVO;
import com.entity.view.DiangexinxiView;


/**
 * 点歌信息
 * 
 * @author 
 * @email 
 * @date 2021-02-27 21:18:32
 */
public interface DiangexinxiDao extends BaseMapper<DiangexinxiEntity> {
	
	List<DiangexinxiVO> selectListVO(@Param("ew") Wrapper<DiangexinxiEntity> wrapper);
	
	DiangexinxiVO selectVO(@Param("ew") Wrapper<DiangexinxiEntity> wrapper);
	
	List<DiangexinxiView> selectListView(@Param("ew") Wrapper<DiangexinxiEntity> wrapper);

	List<DiangexinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiangexinxiEntity> wrapper);
	
	DiangexinxiView selectView(@Param("ew") Wrapper<DiangexinxiEntity> wrapper);
	
}
