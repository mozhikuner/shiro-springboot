package com.jk.service;

import com.jk.model.ResultPage;
import com.jk.model.RoleBean;
import com.jk.model.TreeBean;
import com.jk.model.UserBean;

import java.util.List;

/**
 * 项目名称：boot-shirotest
 * 类描述：
 * 创建人：马艳坤
 * 创建人电话：18634142404
 * 创建时间：2018/10/7    20:14
 * 修改人：MK
 * 修改时间：2018/10/7    20:14
 * 修改备注：
 */
public interface UserService {

    /**
     *getUserByName (通过账号  数据库获取用户)
     * 创建人：马艳坤
     * 创建时间：2018/10/7   21:16
     * 备注：
     * @param userName
     * @return com.jk.model.UserBean
     */
    UserBean getUserByName(String userName);

    /**
     *queryUserList (查询用户列表)
     * 创建人：马艳坤
     * 创建时间：2018/10/7   21:38
     * 备注：
     * @return com.jk.model.ResultPage
     */
    ResultPage queryUserList(UserBean userBean);

    /**
     *queryMkTree (查询主页权限树)
     * 创建人：马艳坤
     * 创建时间：2018/10/8   14:39
     * 备注：id是用户id
     * @param id
     * @return java.util.List<com.jk.model.TreeBean>
     */
    List<TreeBean> queryMkTree(String id);

    /**
     * (queryUserPower查询用户按钮权限)
     * 创建人：马艳坤
     * 创建时间：2018/10/10   10:12
     * 备注：
     * @param
     * @param id
     * @return
     */
    List<TreeBean> queryUserPower(String id);

    /**
     *queryMkRole (增加用户信息时，给用户添加角色信息)
     * 创建人：马艳坤
     * 创建时间：2018/10/10   14:04
     * @return java.util.List<com.jk.model.RoleBean>
     */
    List<RoleBean> queryMkRole();

    /**
     *addUserInfo (增加用户信息)
     * 创建人：马艳坤
     * 创建时间：2018/10/10   14:05
     * 备注：
     * @param userBean
     */
    void addUserInfo(UserBean userBean);

    /**
     *deleteUserInfo (删除用户信息)
     * 创建人：马艳坤
     * 创建时间：2018/10/10   14:05
     * 备注：
     * @param ids
     */
    void deleteUserInfo(String ids);

    /**
     *updateQueryUserById (修改用户回显)
     * 创建人：马艳坤
     * 创建时间：2018/10/10   16:51
     * 备注：
     * @param id
     * @return java.lang.String
     */
    UserBean updateQueryUserById(String id);

    /**
     *updateUserInfo (请描述一下这个方法)
     * 创建人：马艳坤
     * 创建时间：2018/10/10   17:33
     * 备注：
     * @param userBean
     * @return void
     */
    void updateUserInfo(UserBean userBean);

}
