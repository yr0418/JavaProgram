package com.hubu.work.web.controller;

import com.hubu.work.mybatis.pojo.TeamInfo;
import com.hubu.work.web.common.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @moduleName: TeamInfoController
 * @description: teamInfo 对应的Controller 层
 * @author: 杨睿
 * @since: 2019-10-24 14:37
 **/
@RestController
@RequestMapping(value = "teamInfo")
public class TeamInfoController extends BaseController<TeamInfo> {
}
