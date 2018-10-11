package com.jk.model;

import java.io.Serializable;

/**
 * 项目名称：boot-shirotest
 * 类描述：
 * 创建人：lh
 * 创建人电话：18634142404
 * 创建时间：2018/10/8    14:32
 * 修改人：MK
 * 修改时间：2018/10/8    14:32
 * 修改备注：
 */
public class TreeBean implements Serializable {

    /*
     *权限表主键id
     */
    private String id;
    /*
     *权限名称
     */
    private String text;
    /*
     *权限跳转 路径
     */
    private String url;
    /*
     *权限表pid
     */
    private String pid;

    /*
     *具体权限powerId
     */
    private String power;

    /*
     *类型：是tree还是按钮
     */
    private String typeId;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
}
