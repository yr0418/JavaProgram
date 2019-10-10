package com.hubu.work;

import com.hubu.work.mybatis.bean.MessageInfo;
import com.hubu.work.mybatis.mapper.AuditInfoMapper;
import com.hubu.work.mybatis.mapper.SktMapper;
import com.hubu.work.mybatis.mapper.UserInfoMapper;
import com.hubu.work.mybatis.mapper.UserMessageMapper;
import com.hubu.work.mybatis.pojo.Skt;
import com.hubu.work.mybatis.pojo.UserInfo;
import com.hubu.work.mybatis.pojo.UserMessage;
import com.hubu.work.web.service.AuditInfoService;
import net.bytebuddy.asm.Advice;
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
	UserMessageMapper userMessageMapper;

	@Autowired
	AuditInfoService auditInfoService;

	@Autowired
	AuditInfoMapper auditInfoMapper;

	@Test
	public void t1(){

		MessageInfo messageInfo2 = new MessageInfo();
		messageInfo2.setType(3);
		messageInfo2.setSum(auditInfoService.getAuditInfoCountWithSend("root"));
		messageInfo2.setUnreadCount(auditInfoService.getAuditInfoCountWithSendAndUnread("root"));
		System.out.println(messageInfo2.toString());
	}

	@Test
	public void t2(){
		MessageInfo messageInfo2 = new MessageInfo();
		messageInfo2.setType(3);
		messageInfo2.setSum(auditInfoMapper.getAuditInfoCountWithSend("root"));
		messageInfo2.setUnreadCount(auditInfoMapper.getAuditInfoCountWithSendAndUnread("root"));
		System.out.println(messageInfo2.toString());
	}



}
