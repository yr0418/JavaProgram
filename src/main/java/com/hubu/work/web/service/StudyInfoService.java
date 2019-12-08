package com.hubu.work.web.service;

import com.github.pagehelper.Page;
import com.hubu.work.mybatis.bean.QueryInfo;
import com.hubu.work.mybatis.mapper.StudyInfoMapper;
import com.hubu.work.mybatis.pojo.StudyInfo;
import com.hubu.work.web.common.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @moduleName: StudyInfoService
 * @description: StudyInfo 对应的 Service 层
 * @author: 刘江
 * @since: 2019-10-21 14:23
 **/
@Service
public class StudyInfoService extends BaseService<StudyInfo> {
    @Autowired
    StudyInfoMapper studyInfoMapper;

    public Page<StudyInfo> getStudyInfoWithType1AndSchool(String school){
        return studyInfoMapper.getStudyInfoWithType1AndSchool(school);
    }

    public Page<StudyInfo> getStudyInfoWithType2(){
        return studyInfoMapper.getStudyInfoWithType2();
    }

    public Page<StudyInfo> selectStudyInfoWithQueryInfo(QueryInfo queryInfo){
        return studyInfoMapper.selectStudyInfoWithQueryInfo(queryInfo);
    }

    public int unValid(Long id){
        return studyInfoMapper.unValid(id);
    }

    public Page<StudyInfo> getStudyInfoWithUserIssue(String username){
        return studyInfoMapper.getStudyInfoWithUserIssue(username);
    }

    public Page<StudyInfo> getStudyInfoWithUserAttend(List<Integer> ids){
        return studyInfoMapper.getStudyInfoWithUserAttend(ids);
    }

    public int setLeftSizeDecrease(Long id){
        return studyInfoMapper.setLeftSizeDecrease(id);
    }

    public int getLeftSize(Long id){
        return studyInfoMapper.getLeftSize(id);
    }
}
