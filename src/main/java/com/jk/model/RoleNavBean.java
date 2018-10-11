/** 
 * <pre>项目名称:maven-day1 
 * 文件名称:RoleNavBean.java 
 * 包名:com.jk.domain.rolenav 
 * 创建日期:2018年8月6日下午5:22:23 
 * Copyright (c) 2018, 634369607@qq.com All Rights Reserved.</pre> 
 */  
package com.jk.model;

import java.io.Serializable;

/** 
 * <pre>项目名称：maven-day1    
 * 类名称：RoleNavBean    
 * 类描述：    
 * 创建人：马艳坤 
 * 创建时间：2018年8月6日 下午5:22:23    
 * 修改人：MK     
 * 修改时间：2018年8月6日 下午5:22:23    
 * 修改备注：       
 * @version </pre>    
 */
public class RoleNavBean extends Page implements Serializable{

	private static final long serialVersionUID = -7910919692751956021L;
	private String id;
	private String role_id;
	private String nav_id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getNav_id() {
		return nav_id;
	}
	public void setNav_id(String nav_id) {
		this.nav_id = nav_id;
	}
	
	
}
