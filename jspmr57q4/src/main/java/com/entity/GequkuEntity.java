package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 歌曲库
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2021-02-27 21:18:32
 */
@TableName("gequku")
public class GequkuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public GequkuEntity() {
		
	}
	
	public GequkuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 歌曲名称
	 */
					
	private String gequmingcheng;
	
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：歌曲名称
	 */
	public void setGequmingcheng(String gequmingcheng) {
		this.gequmingcheng = gequmingcheng;
	}
	/**
	 * 获取：歌曲名称
	 */
	public String getGequmingcheng() {
		return gequmingcheng;
	}
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
