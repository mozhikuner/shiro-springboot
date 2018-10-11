package com.jk.controller;

import com.jk.model.ResultPage;
import com.jk.model.RoleBean;
import com.jk.model.TreeBean;
import com.jk.model.UserBean;
import com.jk.service.UserService;
import com.jk.utils.UUIDUtil;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.catalina.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Result;
import java.util.List;

/**
 * 项目名称：boot-shirotest
 * 类描述：
 * 创建人：马艳坤
 * 创建人电话：18634142404
 * 创建时间：2018/10/7    19:29
 * 修改人：MK
 * 修改时间：2018/10/7    19:29
 * 修改备注：
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     *toLogin (跳转登录页面)
     * 创建人：马艳坤
     * 创建时间：2018/10/7   20:44
     * 备注：
     * @return java.lang.String
     */
    @RequestMapping("toLogin")
    String toLogin(){
        return "/login";
    }

    /**
     *userLogin (登录方法)
     * 创建人：马艳坤
     * 创建时间：2018/10/7   21:22
     * 备注：
     * @param request
     * @return java.lang.String
     */
    @RequestMapping("login")
    String userLogin(HttpServletRequest request){
        //获取到当前认证器所抛出的异常类的类名
        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
        if (UnknownAccountException.class.getName().equals(exceptionClassName) || AuthenticationException.class.getName().equals(exceptionClassName)) {
            request.setAttribute("flag","账号不存在");
        }
        if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            request.setAttribute("flag","密码错误");
        }
        return "/login";
    }

    /**
     *toMain (登录成功跳转主页面)
     * 创建人：马艳坤
     * 创建时间：2018/10/7   21:27
     * 备注：
     * @return java.lang.String
     */
    @RequestMapping("toMain")
    String toMain (ModelMap map,HttpServletRequest request){
        Subject subject = SecurityUtils.getSubject();
        UserBean userBean = (UserBean) subject.getPrincipal();
        request.getSession().setAttribute("users",userBean);
        map.put("username",userBean.getName());
        return "/main";
    }

    @RequestMapping("toShowUserList")
    @RequiresPermissions("user:get")
    String toShowUserList(){
        return "showUser";
    }

    /**
     *queryUserList (查询用户列表)
     * 创建人：马艳坤
     * 创建时间：2018/10/7   21:36
     * 备注：
     * @return com.jk.model.ResultPage
     */
    @RequestMapping("queryMkUser")
    @ResponseBody
    @RequiresPermissions("user:get")
    ResultPage queryUserList(UserBean userBean){
        ResultPage result= userService.queryUserList(userBean);
        return result;
    }

    /**
     *toPower (没有权限是跳转的页面)
     * 创建人：马艳坤
     * 创建时间：2018/10/7   21:33
     * 备注：
     * @return java.lang.String
     */
    @RequestMapping(value = "toNoPower",method = RequestMethod.GET)
    String toNoPower(){
        return "/warning";
    }

    /**
    *logout (退出登录)
    * 创建人：马艳坤
    * 创建时间：2018/10/8   15:39
    * 备注：
    * @param
    * @return java.lang.String
     */
    @RequestMapping("logout")
    String logout(){
        Subject subject = SecurityUtils.getSubject();
        UserBean userBean = (UserBean) subject.getPrincipal();
        System.out.println(userBean.getId());
        subject.logout();
        return "redirect:/user/toLogin";
    }

    /**
     *queryMkTree (查询权限树)
     * 创建人：马艳坤
     * 创建时间：2018/10/8   15:40
     * 备注：
     * @param
     * @return java.util.List<com.jk.model.TreeBean>
     */
    @RequestMapping("queryMkTree")
    @ResponseBody
    List<TreeBean> queryMkTree(HttpServletRequest request){
        UserBean userBean = (UserBean) request.getSession().getAttribute("users");
        return userService.queryMkTree(userBean.getId());
    }

    /**
     *toAddUser (跳转新增页面)
     * 创建人：马艳坤
     * 创建时间：2018/10/10   13:57
     * 备注：
     * @return java.lang.String
     */
    @RequestMapping("toAddMkUser")
    @RequiresPermissions("user:add")
    String toAddMkUser(ModelMap map){
        List<RoleBean> role = userService.queryMkRole();
        map.put("role", role);
        return "addUser";
    }

    /**
     *addUserInfo (增加用户信息)
     * 创建人：马艳坤
     * 创建时间：2018/10/10   13:58
     * 备注：
     * @param userBean
     * @return java.lang.Boolean
     */
    @RequestMapping("addMkUserInfo")
    @ResponseBody
    @RequiresPermissions("user:add")
    Boolean addUserInfo(UserBean userBean){
        try {
            userService.addUserInfo(userBean);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     *deleteUserInfo (删除用户)
     * 创建人：马艳坤
     * 创建时间：2018/10/10   17:28
     * 备注：
     * @param ids
     * @return java.lang.Boolean
     */
    @RequestMapping("deleteUserInfo")
    @ResponseBody
    @RequiresPermissions("user:delete")
    Boolean deleteUserInfo(String ids){
        try {
            userService.deleteUserInfo(ids);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     *updateQueryUserById (修改用户信息：用户回显)
     * 创建人：马艳坤
     * 创建时间：2018/10/10   17:29
     * 备注：
     * @param id
     * @return java.lang.String
     */
    @RequestMapping("updateQueryMkUser")
    @RequiresPermissions("user:edit")
    String updateQueryUserById(String id,ModelMap map){
        UserBean user = userService.updateQueryUserById(id);
        List<RoleBean> role = userService.queryMkRole();
        map.put("role", role);
        map.put("User",user);
        return "updataUser";
    }

    @RequestMapping("updateMkUser")
    @ResponseBody
    Boolean updateUserInfo(UserBean userBean){
        try {
            userService.updateUserInfo(userBean);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
