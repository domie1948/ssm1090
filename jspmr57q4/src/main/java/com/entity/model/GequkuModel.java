package com.entity.model;

import com.entity.GequkuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 歌曲库
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2021-02-27 21:18:32
 */
public class GequkuModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 歌曲类型
	 */
	
	private String gequleixing;
		
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * 歌手
	 */
	
	private String geshou;
		
	/**
	 * 专辑
	 */
	
	private String zhuanji;
		
	/**
	 * 发行方
	 */
	
	private String faxingfang;
		
	/**
	 * 版权方
	 */
	
	private String banquanfang;
		
	/**
	 * 歌词
	 */
	
	private String geci;
				
	
	/**
	 * 设置：歌曲类型
	 */
	 
	public void setGequleixing(String gequleixing) {
		this.gequleixing = gequleixing;
	}
	
	/**
	 * 获取：歌曲类型
	 */
	public String getGequleixing() {
		return gequleixing;
	}
				
	
	/**
	 * 设置：封面
	 */
	 
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
				
	
	/**
	 * 设置：歌手
	 */
	 
	public void setGeshou(String geshou) {
		this.geshou = geshou;
	}
	
	/**
	 * 获取：歌手
	 */
	public String getGeshou() {
		return geshou;
	}
				
	
	/**
	 * 设置：专辑
	 */
	 
	public void setZhuanji(String zhuanji) {
		this.zhuanji = zhuanji;
	}
	
	/**
	 * 获取：专辑
	 */
	public String getZhuanji() {
		return zhuanji;
	}
				
	
	/**
	 * 设置：发行方
	 */
	 
	public void setFaxingfang(String faxingfang) {
		this.faxingfang = faxingfang;
	}
	
	/**
	 * 获取：发行方
	 */
	public String getFaxingfang() {
		return faxingfang;
	}
				
	
	/**
	 * 设置：版权方
	 */
	 
	public void setBanquanfang(String banquanfang) {
		this.banquanfang = banquanfang;
	}
	
	/**
	 * 获取：版权方
	 */
	public String getBanquanfang() {
		return banquanfang;
	}
				
	
	/**
	 * 设置：歌词
	 */
	 
	public void setGeci(String geci) {
		this.geci = geci;
	}
	
	/**
	 * 获取：歌词
	 */
	public String getGeci() {
		return geci;
	}
			
}
