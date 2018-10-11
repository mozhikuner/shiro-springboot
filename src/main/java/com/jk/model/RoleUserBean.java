/** 
 * <pre>项目名称:maven-day1 
 * 文件名称:RoleUserBean.java 
 * 包名:com.jk.domain.roleanduser 
 * 创建日期:2018年8月3日下午10:46:44 
 * Copyright (c) 2018, 634369607@qq.com All Rights Reserved.</pre> 
 */  
package com.jk.model;

import java.io.Serializable;

/** 
 * <pre>项目名称：maven-day1    
 * 类名称：RoleUserBean    
 * 类描述：    
 * 创建人：马艳坤 
 * 创建时间：2018年8月3日 下午10:46:44    
 * 修改人：MK     
 * 修改时间：2018年8月3日 下午10:46:44    
 * 修改备注：       
 * @version </pre>    
 */
public class RoleUserBean  extends Page implements Serializable{

	private static final long serialVersionUID = 4819519446991469981L;

	private String id;
	
	private String user_id;
	
	private String role_id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	
}
