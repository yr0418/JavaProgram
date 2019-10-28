package com.hubu.work.mybatis.pojo;

import javax.persistence.Id;

public class Test {
    @Id
    private Integer id;

    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}