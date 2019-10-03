package com.hubu.work.mybatis.bean;

import lombok.Data;
/**
 * @moduleName User
 * @description 保存用户名与对应的密码，仅用于登陆操作
 *
 * @author 杨睿
 */
@Data
public class User {
  private String username;
  private String password;
}
