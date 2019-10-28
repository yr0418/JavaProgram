package com.hubu.work.mybatis.pojo;

import javax.persistence.Id;

/**
 * @moduleName: TeamInfo
 * @description: 保存用户的组队信息
 *
 * @author: 杨睿
 */
public class TeamInfo {
    @Id
    private Long id;

    private String username;

    private Integer actionType;

    private Integer actionId;

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

    public Integer getActionType() {
        return actionType;
    }

    public void setActionType(Integer actionType) {
        this.actionType = actionType;
    }

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }
}