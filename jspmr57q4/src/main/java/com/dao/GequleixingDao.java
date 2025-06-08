package com.dao;

import com.entity.GequleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GequleixingVO;
import com.entity.view.GequleixingView;


/**
 * 歌曲类型
 * 
 * @author 
 * @email 
 * @date 2021-02-27 21:18:32
 */
public interface GequleixingDao extends BaseMapper<GequleixingEntity> {
	
	List<GequleixingVO> selectListVO(@Param("ew") Wrapper<GequleixingEntity> wrapper);
	
	GequleixingVO selectVO(@Param("ew") Wrapper<GequleixingEntity> wrapper);
	
	List<GequleixingView> selectListView(@Param("ew") Wrapper<GequleixingEntity> wrapper);

	List<GequleixingView> selectListView(Pagination page,@Param("ew") Wrapper<GequleixingEntity> wrapper);
	
	GequleixingView selectView(@Param("ew") Wrapper<GequleixingEntity> wrapper);
	
}
