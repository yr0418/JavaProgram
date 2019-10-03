package com.hubu.work;

import com.hubu.work.mybatis.mapper.SktMapper;
import com.hubu.work.mybatis.mapper.UserInfoMapper;
import com.hubu.work.mybatis.pojo.Skt;
import com.hubu.work.utils.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkApplicationTests {
@Autowired
SktMapper sktMapper;
@Test
	public void t1(){
	Skt skt = new Skt();
	skt.setUsername("111");
	skt.setPassword("111");
	sktMapper.insert(skt);

}

	}
