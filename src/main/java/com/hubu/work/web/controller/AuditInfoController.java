package com.hubu.work.web.controller;

import com.hubu.work.mybatis.pojo.AuditInfo;
import com.hubu.work.mybatis.pojo.TeamInfo;
import com.hubu.work.utils.DateUtil;
import com.hubu.work.web.common.BaseController;
import com.hubu.work.web.service.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @moduleName: AuditInfoController
 * @description: Audit_info 对应的控制器，提供处理申请消息的API
 * @author: 杨睿
 * @since: 2019-10-10 14:40
 **/
@RestController
@RequestMapping(value = "auditInfo")
public class AuditInfoController extends BaseController<AuditInfo> {
    @Autowired
    DateUtil dateUtil;

    @Autowired
    AuditInfoService auditInfoService;

    @Autowired
    UserMessageService userMessageService;

    @Autowired
    TeamInfoService teamInfoService;

    @Autowired
    EnjoyInfoService enjoyInfoService;

    @Autowired
    EnjoyInfoController enjoyInfoController;

    @Autowired
    StudyInfoService studyInfoService;

    @Autowired
    StudyInfoController studyInfoController;

    @Override
    public int insert(@RequestBody AuditInfo auditInfo) {
        auditInfo.setDate(dateUtil.setTime());
        auditInfo.setAuditStatus(0);
        auditInfo.setAuditResult(0);
        return auditInfoService.insert(auditInfo);
    }

    @ApiOperation(value = "审核申请信息")
    @PostMapping(value = "readAuditInfo")
    public int readAuditInfo(Integer result, Long id) {
        int enjoyInfo = 3;
        AuditInfo auditInfo = auditInfoService.selectById(id);
        if (result == 0) {
            //联动UserMessageController，插入提示信息
            userMessageService.sendMessageWithAuditFail(auditInfo.getReceiver(), auditInfo.getSender());
        } else {
            //联动UserMessageController，插入提示信息
            userMessageService.sendMessageWithAuditSuccess(auditInfo.getReceiver(), auditInfo.getSender());
            //联动 teamInfo表，完成用户入队
            TeamInfo teamInfo = new TeamInfo();
            teamInfo.setActionId(auditInfo.getActionId());
            teamInfo.setActionType(auditInfo.getActionType());
            teamInfo.setUsername(auditInfo.getSender());
            teamInfoService.insert(teamInfo);
            //获取所参与活动的id，便于后续联动操作
            Long actionId = Long.parseLong(auditInfo.getActionId().toString());
            //活动类型为 enjoy
            if (teamInfo.getActionType() == enjoyInfo) {
                //该活动的剩余空位 -1
                enjoyInfoService.setLeftSizeDecrease(actionId);
                //判断该活动是否还有剩余空位，当剩余空位为  0 时，该活动失效，联动该活动失效时需要执行的操作
                if (enjoyInfoService.getLeftSize(actionId) == 0) {
                    enjoyInfoController.withDraw(actionId, auditInfo.getReceiver());
                }
            }
            //活动类型为 study
            else {
                studyInfoService.setLeftSizeDecrease(actionId);
                if (studyInfoService.getLeftSize(actionId) == 0) {
                    studyInfoController.withDraw(actionId, auditInfo.getReceiver());
                }
            }
        }
        return auditInfoService.readAuditInfo(result, id);
    }

    @ApiOperation(value = "获取用户接收到的用户申请信息")
    @GetMapping(value = "getAuditInfoWithReceived")
    public List<AuditInfo> getAuditInfoWithReceived(String username) {
        List<AuditInfo> list1 = auditInfoService.selectAuditInfoWithReceiveAndUnread(username);
        List<AuditInfo> list2 = auditInfoService.selectAuditInfoWithReceiveAndRead(username);
        List<AuditInfo> result = new ArrayList<>();
        result.addAll(list1);
        result.addAll(list2);
        return result;
    }

    @ApiOperation(value = "获取用户发送的入队申请信息")
    @GetMapping(value = "getAuditInfoWithSend")
    public List<AuditInfo> getAuditInfoWithSend(String username) {
        List<AuditInfo> list1 = auditInfoService.selectAuditInfoWithSendAndRead(username);
        List<AuditInfo> list2 = auditInfoService.selectAuditInfoWithSendAndUnread(username);
        List<AuditInfo> result = new ArrayList<>();
        result.addAll(list1);
        result.addAll(list2);
        return result;
    }
}
