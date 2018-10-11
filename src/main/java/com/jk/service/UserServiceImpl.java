package com.jk.service;

import com.jk.mapper.UserMapper;
import com.jk.model.*;
import com.jk.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：boot-shirotest
 * 类描述：
 * 创建人：lh
 * 创建人电话：18634142404
 * 创建时间：2018/10/7    20:38
 * 修改人：MK
 * 修改时间：2018/10/7    20:38
 * 修改备注：
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public UserBean getUserByName(String userName){
        UserBean user= userMapper.getUserByName(userName);
        return user;
    }

    public ResultPage queryUserList(UserBean userBean){
        userBean.calculate();
        ResultPage result = new ResultPage();
        int total = userMapper.queryUserListTotal();
        List<UserBean> users= userMapper.queryUserListInfo();
        result.setRows(users);
        result.setTotal(total);
        return result;
    }

    /*
     *id是用户id
     */
    public List<TreeBean> queryMkTree(String id) {
        return userMapper.queryNavTree(id);
    }

   /*递归查询树
   @Override
   public List<TreeBean> queryMkTree(String id) {
        List<TreeBean> childrenNodeList = userMapper.queryNavTreeChildrenListByUserId(id, UserConconf.POWERTYPETREE);
        ArrayList<TreeBean> treeBeanArrayList = new ArrayList<>();
        childrenNodeList.forEach(treeBeanArrayList::add);
        //获取自己点的父节点
        getParentByChildern(treeBeanArrayList,childrenNodeList);
        //去除list的重复数据
        HashSet<TreeBean> hashSet = new HashSet<>(treeBeanArrayList);
        treeBeanArrayList.clear();
        treeBeanArrayList.addAll(hashSet);
        return treeBeanArrayList;
    }

    private void getParentByChildern(ArrayList<TreeBean> treeBeanArrayList, List<TreeBean> childrenNodeList) {
        for (TreeBean navBean : childrenNodeList) {
            treeBeanArrayList.add(navBean);
            //获取子节点的父节点
            TreeBean parentNode = userMapper.getParentByChildern(navBean.getPid());
            //父节点不为空走if里的内容
            if (parentNode != null) {
                treeBeanArrayList.add(parentNode);
                ArrayList<TreeBean> children = new ArrayList<>();
                children.add(parentNode);
                getParentByChildern(treeBeanArrayList, children);
            }
        }
    }*/

    @Override
    public List<TreeBean> queryUserPower(String id) {
        return userMapper.queryUserPower(id);
    }

    @Override
    public List<RoleBean> queryMkRole() {
        return userMapper.queryMkRole();
    }

    @Override
    public void addUserInfo(UserBean userBean) {
        String userid= UUIDUtil.getUUID();
        String roleUserId=UUIDUtil.getUUID();
        userBean.setId(userid);
        userMapper.addUserInfo(userBean);
        String roleIds = userBean.getRoleId();
        ArrayList<RoleUserBean> roleUserBeans = new ArrayList<>();
        RoleUserBean roleUserBean = new RoleUserBean();
        String[] roleId = roleIds.split(",");
        for (int i = 0; i <roleId.length ; i++) {
            roleUserBean.setId(roleUserId);
            roleUserBean.setRole_id(roleId[i]);
            roleUserBean.setUser_id(userid);
            roleUserBeans.add(roleUserBean);
        }
        userMapper.addUserRoleInfo(roleUserBeans);
    }

    @Override
    public void deleteUserInfo(String ids) {
        userMapper.deleteUserInfo(ids);
    }

    @Override
    public UserBean updateQueryUserById(String id) {
        return userMapper.updateQueryUserById(id);
    }

    @Override
    public void updateUserInfo(UserBean userBean) {
        userMapper.updateUserInfo(userBean);
    }

}
