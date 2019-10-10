package com.hubu.work.mybatis.bean;

import lombok.Data;

/**
 * @moduleName UserFriend
 * @description 以对象的形式保存用户的简单信息：username，nickname，userImgUrl
 *
 * @author 杨睿
 * @since 2019/9/24 18:55
 */
@Data
public class UserSimpleInfo {
  private String username;
  private String nickname;
  private String userImgUrl;
  private int online;
}
