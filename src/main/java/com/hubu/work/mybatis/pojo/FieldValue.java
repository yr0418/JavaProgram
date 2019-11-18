package com.hubu.work.mybatis.pojo;

import javax.persistence.Id;

/**
 * @moduleName FieldValue
 * @description 保存字段值的意义
 *
 * @author 杨睿
 * @since 2019-11-18 16:45
 */
public class FieldValue {
    @Id
    private Long id;

    private String tableName;

    private String field;

    private String value;

    private String comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field == null ? null : field.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}