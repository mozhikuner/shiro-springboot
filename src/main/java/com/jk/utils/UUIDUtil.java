/** 
 * <pre>项目名称:maven-day1 
 * 文件名称:StringUUID.java 
 * 包名:com.jk.utils 
 * 创建日期:2018年8月4日上午10:41:09 
 * Copyright (c) 2018, 634369607@qq.com All Rights Reserved.</pre> 
 */  
package com.jk.utils;

import java.util.UUID;

/** 
 * <pre>项目名称：maven-day1    
 * 类名称：StringUUID    
 * 类描述：  uuid工具类  
 * 创建人：马艳坤 
 * 创建时间：2018年8月4日 上午10:41:09    
 * 修改人：MK     
 * 修改时间：2018年8月4日 上午10:41:09    
 * 修改备注：       
 * @version </pre>    
 */
public class UUIDUtil {

	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
