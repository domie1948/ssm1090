package com.entity.view;

import com.entity.GequleixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 歌曲类型
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-02-27 21:18:32
 */
@TableName("gequleixing")
public class GequleixingView  extends GequleixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GequleixingView(){
	}
 
 	public GequleixingView(GequleixingEntity gequleixingEntity){
 	try {
			BeanUtils.copyProperties(this, gequleixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
