package com.jk.shiro;

import com.jk.model.TreeBean;
import com.jk.model.UserBean;
import com.jk.service.UserService;
import com.jk.utils.Md5Util;
import com.jk.utils.UserConconf;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    //授权器
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        UserBean user = (UserBean) principals.getPrimaryPrincipal();
        //获取用户所拥有的权限
        List<TreeBean> powers = userService.queryUserPower(user.getId());
        System.out.println(powers);
        //System.out.println(user.getUsername());
        List<String> list = new ArrayList<>();
        for (TreeBean power :powers
             ) {
            if (powers!=null){list.add(power.getPower());}
        }
        System.out.println(list);
        //创建一个简单的授权器
        SimpleAuthorizationInfo sai = new SimpleAuthorizationInfo();
        //设置权限关键字集合
        sai.addStringPermissions(list);
        return sai;
    }


    //认证器 登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken token1 = (UsernamePasswordToken)token ;
        String username = token1.getUsername();
        //token 令牌  token.getPrincipal() 获取到前台页面输入的用户名
        //String userName = token.getPrincipal().toString();
        UserBean user = userService.getUserByName(username);
        if (null == user){
            throw new UnknownAccountException();
        }
       /* char[] password = token1.getPassword();
        String mk = "mk";
        Md5Util.getMd516(mk + password);*/


        //创建一个简单认证器   第一个参数为当前登录用户的主体 可以是用户名 也可以是用户对象 一般都是用户对象
        //第二个参数为数据库查询出来的密码 认证器会用前台传递的密码后查询出来的密码对比
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());
        return simpleAuthenticationInfo;
    }
}
