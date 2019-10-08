package com.hubu.work;

import com.hubu.work.mybatis.mapper.SktMapper;
import com.hubu.work.mybatis.mapper.UserInfoMapper;
import com.hubu.work.mybatis.pojo.Skt;
import com.hubu.work.mybatis.pojo.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WorkApplicationTests {

	@Autowired
	SktMapper sktMapper;

	@Autowired
	UserInfoMapper userInfoMapper;

	@Test
	public void t3(){
		List<UserInfo> list = userInfoMapper.selectAll();
		for (UserInfo user:list
				 ) {
			System.out.println(user);
		}
	}
	@Test
	public void t1(){
		Skt skt = new Skt();
		skt.setPassword("111");
		skt.setUsername("111");
		sktMapper.insert(skt);
	}

	@Test
	public void t2(){
		List<Skt> sktList= sktMapper.selectAll();
		for (Skt skt:sktList
				 ) {
			System.out.println(skt);
		}
	}
}
