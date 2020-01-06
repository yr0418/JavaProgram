package com.hubu.work.web.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hubu.work.mybatis.bean.QueryInfo;
import com.hubu.work.mybatis.pojo.StudyInfo;
import com.hubu.work.mybatis.pojo.TeamInfo;
import com.hubu.work.utils.DateUtil;
import com.hubu.work.utils.PageBean;
import com.hubu.work.web.common.BaseController;
import com.hubu.work.web.service.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static com.hubu.work.utils.Constant.CURRENT_PAGE;
import static com.hubu.work.utils.Constant.PAGE_SIZE;

/**
 * @moduleName: StudyInfoController
 * @description: StudyInfo 对应的 controller 层
 * @author: 杨睿
 * @since: 2019-10-21 14:31
 **/
@RestController
@RequestMapping(value = "studyInfo")
public class StudyInfoController extends BaseController<StudyInfo> {
    @Autowired
    StudyInfoService studyInfoService;

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    DateUtil dateUtil;

    @Autowired
    TeamInfoService teamInfoService;

    @Autowired
    AuditInfoService auditInfoService;

    @Autowired
    UserMessageService userMessageService;

    @Override
    public int insert(@RequestBody StudyInfo studyInfo) {
        studyInfo.setDate(new Date());
        studyInfo.setUserSchool(userInfoService.findUserSchool(studyInfo.getUsername()));
        studyInfo.setLeftSize(studyInfo.getMaxMember() - 1);
        studyInfo.setValid(1);
        return studyInfoService.insert(studyInfo);
    }

    @ApiOperation(value = "撤销发布的组队学习信息")
    @PostMapping(value = "withDraw")
    public int withDraw(Long id, String username) {
        List<String> senders = auditInfoService.getSenderWithStudyInfoNotValid(id);
        auditInfoService.updateAuditInfoWithStudyInfoNotValid(id);
        for (String receiver : senders) {
            userMessageService.sendMessageWithAuditFailByTeamNotValid(username, receiver);
        }
        return studyInfoService.unValid(id);
    }

    @ApiOperation(value = "删除组队学习信息，优先使用该接口")
    @DeleteMapping(value = "deleteStudyInfo")
    public int deleteStudyInfo(Long id, String username) {
        withDraw(id, username);
        return studyInfoService.deleteById(id);
    }

    @ApiOperation(value = "获取组队学习信息")
    @GetMapping(value = "getStudyInfo")
    public PageBean<StudyInfo> getStudyInfo(String username, @RequestParam(defaultValue = CURRENT_PAGE) int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        String school = userInfoService.findUserSchool(username);
        PageHelper.startPage(pageNum, pageSize, true);
        Page type1 = studyInfoService.getStudyInfoWithType1AndSchool(school);

        PageHelper.startPage(pageNum, pageSize, true);
        Page<StudyInfo> type2 = studyInfoService.getStudyInfoWithType2();

        //设置 Page 的相关信息
        Page<StudyInfo> page = RandomPage(type1, type2);
        Long total = type1.getTotal() + type2.getTotal();
        page.setTotal(total);
        page.setPageNum(pageNum);
        page.setPageSize(pageSize + pageSize);
        page.setPages(Math.max(type1.getPages(), type2.getPages()));

        return new PageBean<StudyInfo>(page);
    }

    @ApiOperation(value = "根据查询条件查询组队学习信息")
    @PostMapping(value = "selectStudyInfo")
    public PageBean<StudyInfo> selectStudyInfo(@RequestBody QueryInfo queryInfo, @RequestParam(defaultValue = CURRENT_PAGE) int pageNum, @RequestParam(defaultValue = PAGE_SIZE) int pageSize) {
        queryInfo.setUserSchool(userInfoService.findUserSchool(queryInfo.getUsername()));
        PageHelper.startPage(pageNum, pageSize, true);
        Page<StudyInfo> page = studyInfoService.selectStudyInfoWithQueryInfo(queryInfo);
        return new PageBean<>(page);
    }

    @ApiOperation(value = "获取用户发布的组队学习信息")
    @GetMapping(value = "getStudyInfoWithUserIssue")
    public PageBean<StudyInfo> getStudyInfoWithUserIssue(String username, @RequestParam(defaultValue = CURRENT_PAGE) int pageNum, @RequestParam(defaultValue = PAGE_SIZE) int pageSize) {
        PageHelper.startPage(pageNum, pageSize, true);
        Page<StudyInfo> page = studyInfoService.getStudyInfoWithUserIssue(username);

        //对数据集进行排序处理
        Page<StudyInfo> result = pageSort(page);
        return new PageBean<>(result);
    }

    @ApiOperation(value = "获取用户参加的组队学习信息")
    @GetMapping(value = "getStudyInfoWithUserAttend")
    public PageBean<StudyInfo> getStudyInfoWithUserAttend(String username, @RequestParam(defaultValue = CURRENT_PAGE) int pageNum, @RequestParam(defaultValue = PAGE_SIZE) int pageSize) {
        List<TeamInfo> teamInfos = teamInfoService.selectUserTeam(username);
        List<Integer> ids = new ArrayList<>();
        for (TeamInfo teamInfo : teamInfos) {
            if (teamInfo.getActionType() < 3) {
                ids.add(teamInfo.getActionId());
            }
        }
        Page<StudyInfo> page = new Page();
        if (ids.size() != 0) {
            PageHelper.startPage(pageNum, pageSize, true);
            page = studyInfoService.getStudyInfoWithUserAttend(ids);
            //对数据集进行处理
            Page<StudyInfo> result = pageSort(page);

            return new PageBean<>(result);
        }else {
            return new PageBean<>(page);
        }
    }


    /**
     * 对查询到的组队学习信息进行随机化处理
     *
     * @param type1 线下组队学习信息
     * @param type2 线上组队学习信息
     * @return Page<StudyInfo>
     */
    private static Page<StudyInfo> RandomPage(Page<StudyInfo> type1, Page<StudyInfo> type2) {
        Page<StudyInfo> page = new Page<>();
        Random random = new Random();
        for (int i = 0; i < type1.size() + type2.size(); i++) {
            int type = random.nextInt(2) + 1;
            if (type == 1) {
                if (type1.getPageSize() != 0) {
                    page.add(type1.get(0));
                    type1.remove(0);
                } else {
                    break;
                }
            } else if (type == 2) {
                if (type2.getPageSize() != 0) {
                    page.add(type2.get(0));
                    type2.remove(0);
                } else {
                    break;
                }
            }
        }
        page.addAll(type1);
        page.addAll(type2);
        return page;
    }


    /**
     * 对 page 中的数据集进行排序，将有效的组队信息放在前面
     *
     * @param page 数据集
     * @return 结果集
     */
    private static Page<StudyInfo> pageSort(Page<StudyInfo> page) {
        Page<StudyInfo> result = new Page<>();
        //数据处理，将有效的组队信息放在前面
        for (StudyInfo studyInfo : page) {
            if (studyInfo.getValid() == 1) {
                result.add(studyInfo);
            }
        }
        for (StudyInfo studyInfo : page) {
            if (studyInfo.getValid() == 0) {
                result.add(studyInfo);
            }
        }
        //初始化 result 的属性
        result.setPageSize(page.getPageSize());
        result.setPageNum(page.getPageNum());
        result.setTotal(page.getTotal());
        result.setPages(page.getPages());

        return result;
    }
}
