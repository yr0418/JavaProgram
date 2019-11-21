package com.hubu.work.mybatis.bean;

import lombok.Data;

/**
 * @moduleName:  QueryStudyInfo
 * @description:  封装组队学习信息的查询条件
 * @author: 杨睿
 * @since: 2019/9/30 15:14
 */
@Data
public class QueryInfo {
  /**
   * 组队学习模式，1：线下，2：线上
   */
  private int type;

  /**
   * 当前用户的用户名
   */
  private String username;

  /**
   * 用户所在的学校
   */
  private String userSchool;

  /**
   * 用户所在的城市
   */
  private String userCity;

  /**
   * 用户性别
   */
  private String userSex;

  /**
   * 标签
   */
  private String label;

  /**
   * 性别限制，使用数字标注不同的性别限制，1：只限异性，2：只限同性，3：无限制。
   */
  private  int sexSpecific;

  /**
   * 最大组队人数
   */
  private int maxMember;

  /**
   * 是否有效
   */
  private int valid;
}
