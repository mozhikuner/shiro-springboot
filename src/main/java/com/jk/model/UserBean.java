package com.jk.model;

import java.io.Serializable;

/**
 * 项目名称：boot-shirotest
 * 类描述：
 * 创建人：马艳坤
 * 创建人电话：18634142404
 * 创建时间：2018/10/7    20:07
 * 修改人：MK
 * 修改时间：2018/10/7    20:07
 * 修改备注：
 */
public class UserBean extends Page implements Serializable {

    /*
     *User表主键id
     */
    private String id;
    /*
     *登录账号
     */
    private String username;
    /*
     *登录用户名称
     */
    private String name;
    /*
     *登录密码
     */
    private String password;
    /*
     *权限id
     */
    private String roleId;

    /*
     *批量删除的ids
     */
    private String ids;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
