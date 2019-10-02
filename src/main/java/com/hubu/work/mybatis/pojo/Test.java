package com.hubu.work.mybatis.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @moduleName Test
 * @description 对应数据库中的 test 表，用于测试字段类型
 *
 * @author 杨睿
 */
@Data
public class Test {
    private Integer id;

    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}