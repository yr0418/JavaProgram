package com.hubu.work.web.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hubu.work.mybatis.bean.QueryInfo;
import com.hubu.work.mybatis.pojo.AuditInfo;
import com.hubu.work.mybatis.pojo.EnjoyInfo;
import com.hubu.work.mybatis.pojo.TeamInfo;
import com.hubu.work.utils.PageBean;
import com.hubu.work.web.common.BaseController;
import com.hubu.work.web.service.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.hubu.work.utils.Constant.CURRENT_PAGE;
import static com.hubu.work.utils.Constant.PAGE_SIZE;

/**
 * @moduleName: EnjoyInfoController
 * @description: EnjoyInfo 对应的 Controller 层
 * @author: 杨睿
 * @since: 2019-10-23 16:47
 **/
@RestController
@RequestMapping(value = "enjoyInfo")
public class EnjoyInfoController extends BaseController<EnjoyInfo> {
    @Autowired
    UserInfoService userInfoService;

    @Autowired
    EnjoyInfoService enjoyInfoService;

    @Autowired
    TeamInfoService teamInfoService;

    @Autowired
    AuditInfoService auditInfoService;

    @Autowired
    UserMessageService userMessageService;

    @Override
    public int insert(@RequestBody EnjoyInfo enjoyInfo) {
        enjoyInfo.setUserSex(userInfoService.getUserSex(enjoyInfo.getUsername()));
        enjoyInfo.setUserCity(userInfoService.findUserCity(enjoyInfo.getUsername()));
        enjoyInfo.setDate(new Date());
        enjoyInfo.setLeftSize(enjoyInfo.getMaxMember()-1);
        enjoyInfo.setValid(1);
        return enjoyInfoService.insert(enjoyInfo);
    }

    @ApiOperation(value = "撤销发布的组队玩乐信息")
    @PostMapping(value = "withDraw")
    public int withDraw(Long id,String username){
        List<String> senders = auditInfoService.getSenderWithEnjoyInfoNotValid(id);
        auditInfoService.updateAuditInfoWithEnjoyInfoNotValid(id);
        for (String receiver: senders) {
            userMessageService.sendMessageWithAuditFailByTeamNotValid(username,receiver);
        }
        return enjoyInfoService.unValid(id);
    }

    @ApiOperation(value = "删除组队玩乐信息，优先使用该接口")
    @DeleteMapping(value = "deleteEnjoyInfo")
    public int deleteEnjoyInfo(Long id,String username){
        withDraw(id,username);
        return enjoyInfoService.deleteById(id);
    }

    @ApiOperation(value = "获取组队玩乐信息")
    @GetMapping(value = "getEnjoyInfo")
    public PageBean<EnjoyInfo> getEnjoyInfo(@RequestParam String username,
                                            @RequestParam(defaultValue = CURRENT_PAGE) int pageNum,
                                            @RequestParam(defaultValue = PAGE_SIZE) int pageSize) {
        String city = userInfoService.findUserCity(username);
        PageHelper.startPage(pageNum, pageSize, true);
        Page<EnjoyInfo> page = enjoyInfoService.getEnjoyInfo(city);
        return new PageBean<>(page);
    }

    @ApiOperation(value = "根据查询条件，获取发布的组队信息")
    @PostMapping(value = "selectEnjoyInfo")
    public PageBean<EnjoyInfo> selectEnjoyInfo(@RequestBody QueryInfo queryInfo,
                                               @RequestParam(defaultValue = CURRENT_PAGE) int pageNum,
                                               @RequestParam(defaultValue = PAGE_SIZE) int pageSize) {
        queryInfo.setUserCity(userInfoService.findUserCity(queryInfo.getUsername()));
        queryInfo.setUserSex(userInfoService.getUserSex(queryInfo.getUsername()));
        PageHelper.startPage(pageNum, pageSize, true);
        Page<EnjoyInfo> page = enjoyInfoService.selectEnjoyInfoWithQueryInfo(queryInfo);
        return new PageBean<>(page);
    }

    @ApiOperation(value = "获取用户发布的组队玩乐信息")
    @GetMapping(value = "getEnjoyInfoWithUserIssue")
    public PageBean<EnjoyInfo> getEnjoyInfoWithUserIssue(String username, @RequestParam(defaultValue = CURRENT_PAGE) int pageNum, @RequestParam(defaultValue = PAGE_SIZE) int pageSize) {
        PageHelper.startPage(pageNum, pageSize, true);
        Page<EnjoyInfo> page = enjoyInfoService.getEnjoyInfoWithUserIssue(username);
        //对组队信息进行排序处理
        Page<EnjoyInfo> result = pageSort(page);
        return new PageBean<>(result);

    }

    @ApiOperation(value = "获取用户参加过的组队玩乐活动")
    @GetMapping(value = "getEnjoyInfoWithUserAttend")
    public PageBean<EnjoyInfo> getEnjoyInfoWithUserAttend(@RequestParam String username, @RequestParam(defaultValue = CURRENT_PAGE) int pageNum, @RequestParam(defaultValue = PAGE_SIZE) int pageSize) {
        List<TeamInfo> teamInfos = teamInfoService.selectUserTeam(username);
        List<Integer> ids = new ArrayList<>();
        //获取组队玩乐信息的主键
        for (TeamInfo teamInfo : teamInfos) {
            if (teamInfo.getActionType() == 3) {
                ids.add(teamInfo.getActionId());
            }
        }
        PageHelper.startPage(pageNum, pageSize, true);
        Page<EnjoyInfo> page = enjoyInfoService.getEnjoyInfoWithUserAttend(ids);
        Page<EnjoyInfo> result = pageSort(page);
        return new PageBean<>(result);
    }


    /**
     * 对 page 中的数据集进行排序，将有效的组队信息放在前面
     * @param page 数据集
     * @return 结果集
     */
    private static Page<EnjoyInfo> pageSort(Page<EnjoyInfo> page){
        Page<EnjoyInfo> result = new Page<>();
        //数据处理，将有效的组队信息放在前面
        for (EnjoyInfo enjoyInfo : page) {
            if (enjoyInfo.getValid() == 1) {
                result.add(enjoyInfo);
            }
        }
        for (EnjoyInfo enjoyInfo : page) {
            if (enjoyInfo.getValid() == 0) {
                result.add(enjoyInfo);
            }
        }
        //初始化 result 的属性。
        result.setPageSize(page.getPageSize());
        result.setPageNum(page.getPageNum());
        result.setTotal(page.getTotal());
        result.setPages(page.getPages());

        return result;
    }
}