package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GequleixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GequleixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GequleixingView;


/**
 * 歌曲类型
 *
 * @author 
 * @email 
 * @date 2021-02-27 21:18:32
 */
public interface GequleixingService extends IService<GequleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GequleixingVO> selectListVO(Wrapper<GequleixingEntity> wrapper);
   	
   	GequleixingVO selectVO(@Param("ew") Wrapper<GequleixingEntity> wrapper);
   	
   	List<GequleixingView> selectListView(Wrapper<GequleixingEntity> wrapper);
   	
   	GequleixingView selectView(@Param("ew") Wrapper<GequleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GequleixingEntity> wrapper);
   	
}

