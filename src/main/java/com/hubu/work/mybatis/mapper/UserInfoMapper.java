package com.hubu.work.mybatis.mapper;

import com.hubu.work.mybatis.CustomMapper;
import com.hubu.work.mybatis.bean.User;
import com.hubu.work.mybatis.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;
/**
 * 应用模块名称: UserInfoMapper
 * 代码描述: UserInfo 的 mapper层
 * @author：杨睿
 */
public interface UserInfoMapper extends CustomMapper<UserInfo> {

  /**
   * 查询用户名与密码是否配对
   * @param user：User 对象
   * @return: int
   * 1：配对
   * 0：不配对
   */
  int findUser(User user);

  /**
   * 查询该用户是否存在
   * @param username：用户名
   * @return： int
   * 1：该用户已存在
   * 0：该用户不存在
   */
  int findUsername(@Param("username") String username);

  /**
   * 查询该昵称是否被使用
   * @param nickname：用户昵称
   * @return int
   * 1：该昵称已被使用
   * 0：改昵称未使用
   */
  int findUserNickname(@Param("nickname") String nickname);

  /**
   * 查询用户头像的路径
   * @param username：用户名
   * @return String
   * 返回用户头像的路径
   */
  String findUserImg(@Param("username") String username);

  /**
   * 更新用户头像路径
   * @param userImgPath：头像路径
   * @param username：用户名
   * @return int
   * 1：更新成功
   * 0：更新失败
   */
  int updateUserImg(@Param("userImgPath") String userImgPath, @Param("username") String username);

  /**
   * 查询用户所在的城市
   * @param username：用户名
   * @return String
   * 返回用户所在的城市名
   */
  String findUserCity(@Param("username") String username);

  /**
   * 查询用户所在的学校
   * @param username：用户名
   * @return String
   * 返回用户所在的学校名
   */
  String findUserSchool(@Param("username") String username);

  /**
   * 修改用户个性签名
   * @param personalizedSignature：用户个性签名
   * @param username：用户名
   * @return int
   * 1：修改成功
   * 0：修改失败
   */
  int updateUserPersonalizedSignature(@Param("personalizedSignature") String personalizedSignature,
                                      @Param("username") String username);

  /**
   * 修改用户信息，当传入的字段对应的属性值为 null 时，不会修改数据库中的数据
   * @param userInfo
   * @return int
   * 1：修改成功
   * 0：修改失败
   */
  int update(UserInfo userInfo);

  /**
   * 查询用户基本信息
   * @param username：用户名
   * @return UserInfo实例化对象
   */
  UserInfo getUserInfo(@Param("username") String username);
}