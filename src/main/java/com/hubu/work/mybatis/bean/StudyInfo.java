package com.hubu.work.mybatis.bean;

import lombok.Data;

/**
 * @moduleName StudyInfo
 * @description 封装用户发布的组队信息，方便前台传入数据
 *
 * @author 杨睿
 * @since 2019/9/26 15:46
 */
@Data
public class StudyInfo {
    /**
     * 活动的id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户头像地址
     */
    private String userImgUrl;

    /**
     * 模式：1：线下，2：线上
     */
    private int type;

    /**
     * 最大组队人数，包括发布者自己
     */
    private int maxMember;

    /**
     * 空位
     */
    private int leftMember;

    /**
     * 学习标签
     */
    private String label;

    /**
     * 学习时间
     */
    private String time;

    /**
     * 学习地点
     */
    private String site;

    /**
     * 备注
     */
    private String ps;

    /**
     * 该消息发布的时间
     */
    private String date;

    /**
     * 该组队信息是否有效，1：有效，0：无效
     */
    private int valid;
}
