package com.hubu.work.mybatis.bean;

import lombok.Data;

/**
 * @模块名称 QueryStudyInfo
 * @模块功能描述 封装组队学习信息的查询条件
 * @Author 杨睿
 * @since 2019/9/30 15:14
 */
@Data
public class QueryStudyInfo {
  /**
   * 组队学习模式，1：线下，2：线上
   */
  private int type;

  /**
   * 当前用户的用户名
   */
  private String username;

  /**
   * 组队学习标签
   */
  private String label;

  /**
   * 最大组队人数
   */
  private int maxMember;
}
