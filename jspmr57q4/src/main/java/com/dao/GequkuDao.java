package com.dao;

import com.entity.GequkuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GequkuVO;
import com.entity.view.GequkuView;


/**
 * 歌曲库
 * 
 * @author 
 * @email 
 * @date 2021-02-27 21:18:32
 */
public interface GequkuDao extends BaseMapper<GequkuEntity> {
	
	List<GequkuVO> selectListVO(@Param("ew") Wrapper<GequkuEntity> wrapper);
	
	GequkuVO selectVO(@Param("ew") Wrapper<GequkuEntity> wrapper);
	
	List<GequkuView> selectListView(@Param("ew") Wrapper<GequkuEntity> wrapper);

	List<GequkuView> selectListView(Pagination page,@Param("ew") Wrapper<GequkuEntity> wrapper);
	
	GequkuView selectView(@Param("ew") Wrapper<GequkuEntity> wrapper);
	
}
