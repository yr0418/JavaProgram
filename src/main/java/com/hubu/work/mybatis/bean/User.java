package com.hubu.work.mybatis.bean;

import lombok.Data;
/**
 * 应用模块名称: User
 * 代码描述:保存用户名与对应的密码，仅用于登陆操作
 * @author：杨睿
 */
@Data
public class User {
  private String username;
  private String password;
}
