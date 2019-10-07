package com.hubu.work;

import com.hubu.work.mybatis.mapper.LplMapper;
import com.hubu.work.mybatis.mapper.SktMapper;
import com.hubu.work.mybatis.mapper.UserInfoMapper;
import com.hubu.work.mybatis.pojo.Lpl;
import com.hubu.work.mybatis.pojo.Skt;
import com.hubu.work.utils.DateUtil;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.LeafPropertyLoader;
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
	LplMapper lplMapper;
	@Test
	public void t2(){
		Lpl lpl = new Lpl();
		lpl.setUsername("222");
		lpl.setPassword("222");
		lplMapper.insert(lpl);
	}
}

