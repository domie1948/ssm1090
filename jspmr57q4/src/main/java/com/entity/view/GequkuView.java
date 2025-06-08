package com.entity.view;

import com.entity.GequkuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 歌曲库
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-02-27 21:18:32
 */
@TableName("gequku")
public class GequkuView  extends GequkuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GequkuView(){
	}
 
 	public GequkuView(GequkuEntity gequkuEntity){
 	try {
			BeanUtils.copyProperties(this, gequkuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
