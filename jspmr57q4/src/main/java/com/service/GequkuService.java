package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GequkuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GequkuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GequkuView;


/**
 * 歌曲库
 *
 * @author 
 * @email 
 * @date 2021-02-27 21:18:32
 */
public interface GequkuService extends IService<GequkuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GequkuVO> selectListVO(Wrapper<GequkuEntity> wrapper);
   	
   	GequkuVO selectVO(@Param("ew") Wrapper<GequkuEntity> wrapper);
   	
   	List<GequkuView> selectListView(Wrapper<GequkuEntity> wrapper);
   	
   	GequkuView selectView(@Param("ew") Wrapper<GequkuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GequkuEntity> wrapper);
   	
}

