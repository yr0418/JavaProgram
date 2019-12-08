package com.hubu.work.mybatis.pojo;

import javax.persistence.Id;
import java.util.Date;
/**
 * @moduleName EnjoyInfo
 * @description 封装申请组队玩乐信息
 *
 * @Author 胡嘉兵
 */
public class EnjoyInfo {
    @Id
    private Long id;

    private String username;

    private String userCity;

    private String userSex;

    private String actionName;

    private String label;

    private Integer sexSpecific;

    private String time;

    private String site;

    private Integer maxMember;

    private Integer leftSize;

    private Date date;

    private String ps;

    private Integer valid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity == null ? null : userCity.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName == null ? null : actionName.trim();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    public Integer getSexSpecific() {
        return sexSpecific;
    }

    public void setSexSpecific(Integer sexSpecific) {
        this.sexSpecific = sexSpecific;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site == null ? null : site.trim();
    }

    public Integer getMaxMember() {
        return maxMember;
    }

    public void setMaxMember(Integer maxMember) {
        this.maxMember = maxMember;
    }

    public Integer getLeftSize() {
        return leftSize;
    }

    public void setLeftSize(Integer leftSize) {
        this.leftSize = leftSize;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps == null ? null : ps.trim();
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }
}