package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiangexinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiangexinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiangexinxiView;


/**
 * 点歌信息
 *
 * @author 
 * @email 
 * @date 2021-02-27 21:18:32
 */
public interface DiangexinxiService extends IService<DiangexinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiangexinxiVO> selectListVO(Wrapper<DiangexinxiEntity> wrapper);
   	
   	DiangexinxiVO selectVO(@Param("ew") Wrapper<DiangexinxiEntity> wrapper);
   	
   	List<DiangexinxiView> selectListView(Wrapper<DiangexinxiEntity> wrapper);
   	
   	DiangexinxiView selectView(@Param("ew") Wrapper<DiangexinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiangexinxiEntity> wrapper);
   	
}

