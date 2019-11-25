package com.hubu.work.web.service;

import com.hubu.work.mybatis.mapper.StudyInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @moduleName: StudyInfoService
 * @description: StudyInfo  对应的 Service 层
 * @author: 刘江
 * @since: 2019-11-21 18:16
 **/
@Service
public class StudyInfoService {

    @Autowired
    StudyInfoMapper studyInfoMapper;

    public int setLeftSizeDecrease(Long id){
        return studyInfoMapper.setLeftSizeDecrease(id);
    }

    public int getLeftSize(Long id){ return studyInfoMapper.getLeftSize(id); }
}
