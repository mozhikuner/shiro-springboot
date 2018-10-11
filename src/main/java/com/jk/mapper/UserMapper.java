package com.jk.mapper;

import com.jk.model.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：boot-shirotest
 * 类描述：
 * 创建人：马艳坤
 * 创建人电话：18634142404
 * 创建时间：2018/10/7    20:15
 * 修改人：MK
 * 修改时间：2018/10/7    20:15
 * 修改备注：
 */
@Repository
public interface UserMapper {
    //登录时查询用户
    @Select("select * from t_user where username = #{username}")
    UserBean getUserByName(String userName);

    //查询用户总条数
    @Select("select count(1) from t_user ")
    int queryUserListTotal();

    //查询用户所有信息
    @Select("select * from t_user")
    List<UserBean> queryUserListInfo();

    //递归查询树：通过用户id查询主页权限：
//    @Select("select distinct tn.id , tn.name text , tn.url , tn.pid from t_nav tn\n" +
//            "\t\tleft join t_role_nav trn on tn.id= trn.nav_id\n" +
//            "\t\tleft join t_role tr on tr.id= trn.role_id\n" +
//            "\t\tleft join t_user_role tur on tr.id= tur.role_id\n" +
//            "\t\twhere tur.user_id = #{id} and tn.url is not null and tn.url != '' and typeId = #{typeid}")
//    List<TreeBean> queryNavTreeChildrenListByUserId(@Param("id") String id,@Param("typeid") Integer powertypetree);

    //递归查询树：通过子节点查找父节点
//    @Select("select tn.id , tn.name text , tn.url , tn.pid from t_nav tn where tn.id=#{pid}")
//    TreeBean getParentByChildern(@Param("pid") String pid);

    //查询该用户权限
    @Select("select distinct distinct tn.id , tn.name text , tn.url , tn.pid from t_nav tn\n" +
            "\t\t\t\t\tleft join t_role_nav trn on tn.id = trn.nav_id\n" +
            "\t\t\t\t\tleft join t_role tr on trn.role_id = tr.id\n" +
            "\t\t\t\t\tleft join t_user_role tur on tr.id = tur.role_id\n" +
            "\t\t\t\t\twhere tur.user_id = #{id} and typeId = 0 ")
     List<TreeBean> queryNavTree(@Param("id") String id);

    //查询该用户权限
    @Select("select distinct tn.power power from t_nav tn\n" +
            "\t\t\t\t\tleft join t_role_nav trn on tn.id = trn.nav_id\n" +
            "\t\t\t\t\tleft join t_role tr on trn.role_id = tr.id\n" +
            "\t\t\t\t\tleft join t_user_role tur on tr.id = tur.role_id\n" +
            "\t\t\t\t\twhere tur.user_id = #{id}")
    List<TreeBean> queryUserPower(@Param("id") String id);

    //查询所有角色，进行添加用户时使用
    @Select("select id,name text from t_role")
    List<RoleBean> queryMkRole();

    //添加用户信息
    @Insert("insert into t_user (id,name,username,password,roleId) " +
            "values(#{id},#{name},#{username},#{password},#{roleId})")
    void addUserInfo(UserBean userBean);

    //添加用户角色表信息
    void addUserRoleInfo(ArrayList<RoleUserBean> roleUserBeans);

    //删除用户信息
    @Delete("delete from t_user where id in ( ${ids} )")
    void deleteUserInfo(@Param("ids") String ids);

    //修改用户信息，回显
    @Select("select * from t_user where id = #{value}")
    UserBean updateQueryUserById(String id);

    //修改用户信息
    @Update("update t_user set username=#{username},password=#{password}," +
            "roleId=#{roleId},name=#{name} where id=#{id}")
    void updateUserInfo(UserBean userBean);
}
