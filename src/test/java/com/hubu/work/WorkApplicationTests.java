package com.hubu.work;

import com.hubu.work.mybatis.mapper.UserInfoMapper;
import com.hubu.work.mybatis.pojo.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WorkApplicationTests {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Test
    public void t1(){
        List<UserInfo> userInfos = userInfoMapper.selectAll();
        for (UserInfo userInfo: userInfos) {
            System.out.println(userInfo.toString());
        }
    }


}
