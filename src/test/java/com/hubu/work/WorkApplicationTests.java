package com.hubu.work;

import com.hubu.work.mybatis.mapper.LplMapper;
import com.hubu.work.mybatis.mapper.UserInfoMapper;
import com.hubu.work.mybatis.pojo.Lpl;
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
	UserInfoMapper userInfoMapper;

	@Autowired
	DateUtil dateUtil;


		@Test
	public void t1() throws ParseException {
		String city = userInfoMapper.findUserCity("111");
		System.out.println(city);
	}
	@Autowired
	LplMapper lplMapper;
@Test
	public void t2(){
	Lpl lpl =new Lpl();
	lpl.setUsername("333");
	lpl.setPassword("333");
	lplMapper.insert(lpl);
	}
}
