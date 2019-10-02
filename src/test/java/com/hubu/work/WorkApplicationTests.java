package com.hubu.work;

import com.hubu.work.mybatis.mapper.TestMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkApplicationTests {
	@Autowired
	TestMapper testMapper;

	@Test
	public void contextLoads() throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		com.hubu.work.mybatis.pojo.Test test=new com.hubu.work.mybatis.pojo.Test();
		test.setId(3);
		Date date=simpleDateFormat.parse("2019-10-03");
		test.setTime(date);
		testMapper.insert(test);
	}

	@Test
	public void t2(){
		List<com.hubu.work.mybatis.pojo.Test> list=testMapper.selectByTime("2019-10-01");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		for (com.hubu.work.mybatis.pojo.Test t : list) {
			String date = simpleDateFormat.format(t.getTime());
			System.out.println(date);
		}
	}

}
