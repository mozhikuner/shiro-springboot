/** 
 * <pre>项目名称:maven-day1 
 * 文件名称:RoleBean.java 
 * 包名:com.jk.domain.user 
 * 创建日期:2018年8月3日下午9:40:11 
 * Copyright (c) 2018, 634369607@qq.com All Rights Reserved.</pre> 
 */  
package com.jk.model;

import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jk.model.Page;

/** 
 * <pre>项目名称：maven-day1    
 * 类名称：RoleBean    
 * 类描述：    
 * 创建人：马艳坤 
 * 创建时间：2018年8月3日 下午9:40:11    
 * 修改人：MK     
 * 修改时间：2018年8月3日 下午9:40:11    
 * 修改备注：       
 * @version </pre>    
 */
public class RoleBean extends Page implements Serializable{

	private static final long serialVersionUID = 5538532247926343536L;
	
	/**
	 * 角色主键id
	 */
	private String id;
	/**
	 * 角色名称
	 */
	private String text;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GTM+8")
	private String createTime ;
	
	private String pid;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	
}
