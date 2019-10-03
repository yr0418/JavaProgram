package com.hubu.work.mybatis.pojo;

import lombok.Data;

import javax.persistence.Id;

/**
 * @moduleName UserMessage
 * @description 对应数据库 user_message 表，保存用户收到，发布的消息
 *
 * @author 杨睿
 */
@Data
public class UserMessage {

    @Id
    private Long id;

    private String sender;

    private String receiver;

    private int type;

    private String date;

    private String context;

    private Integer read;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender == null ? null : sender.trim();
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    public Integer getRead() {
        return read;
    }

    public void setRead(Integer read) {
        this.read = read;
    }
}