package com.hubu.work.web.controller;

import com.hubu.work.mybatis.pojo.FieldValue;
import com.hubu.work.web.common.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @moduleName: FieldValueController
 * @description: field_value 对应的 Controller 层
 *
 * @author: 杨睿
 * @since: 2019-11-18 16:48
 **/
@RestController
@RequestMapping(value = "fieldValue")
public class FieldValueController extends BaseController<FieldValue> {
}
