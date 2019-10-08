package com.hubu.work.web.socket;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hubu.work.mybatis.bean.SocketMsg;
import com.hubu.work.mybatis.mapper.UserInfoMapper;
import com.hubu.work.web.service.UserInfoService;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @moduleName WebSocketController
 * @description 因为WebSocket是类似客户端服务端的形式(采用ws协议)，那么这里的WebSocketServer其实就相当于一个ws协议的Controller，直接 @ServerEndpoint("/websocket") @Component启用即可，然后在里面实现@OnOpen,@onClose,@onMessage等方法
 *
 * @author 杨睿
 * @since 2019/9/24 11:04
 */
@ServerEndpoint(value = "/webSocket/{username}")
@Component
public class WebSocketController {

    private static Logger logger = LoggerFactory.getLogger(WebSocketController.class);

    /**
     * 要注入的service或者dao
     */
    private static UserInfoService userInfoService;

    @Autowired
    public void setUserInfoService(UserInfoService userInfoService){
        WebSocketController.userInfoService=userInfoService;
    }

    /**
     * 将 username 与 Session 进行绑定，便于获取指定的 session ，建立连接，发送消息
     */
    private static ConcurrentHashMap<String, Session> websocketMap = new ConcurrentHashMap<>();

    /**
     * 与某个客户端连接通信，需要通过 Session 给客户端发送数据
     */
    private Session session;

    /**
     * 获取连接后台 WebSocket 的用户的 username，使其与 Session 一一对应
     */
    private String username;

    /**
     * 连接成功调用方法
     * 
     * @param session：Session对象
     * @param username：连接的用户的用户名
     */
    @OnOpen
    public void onOpen(@RequestParam("session") Session session, @PathParam("username") String username) {
        this.session = session;
        this.username = username;
        websocketMap.put(username, session);
        userInfoService.online(username);
        logger.info("有新的窗口加入WebSocket，username：" + username);
        sendMessageByBackground(JSON.toJSONString("连接成功"));
    }

    /**
     * 用户关闭连接时调用的方法
     * 
     * @param username：用户名
     */
    @OnClose
    public void onClose(@PathParam("username") String username) {
        if (websocketMap.get(username) != null) {
            websocketMap.remove(username);
            userInfoService.outline(username);
            logger.info("有用户关闭连接：" + username);
        }
    }

    /**
     * 接收来自客户端的信息
     * 
     * @param message：消息内容
     * @param session
     */
    @OnMessage
    public void onMessage(@RequestParam("socketMsg") String message, @RequestParam("session") Session session) {
        logger.info("收到来自用户的消息:" + message);
        ObjectMapper objectMapper = new ObjectMapper();
        /**
         * 保存要发送的消息以及发送者，接收者
         */
        SocketMsg socketMsg;
        try {
            // 前台封装一个 SocketMsg 对象，转化为 json 数据，传递给后台，
            socketMsg = objectMapper.readValue(message, SocketMsg.class);
            // 单聊
            if (socketMsg.getType() == 1) {
                // 获取接收信息的人的 Session
                Session receiver = websocketMap.get(socketMsg.getReceiver());
                receiver.getAsyncRemote().sendText(socketMsg.getMsg());
            } else {
                // 群发消息，给 所有连接该 WebSocket 的用户发送消息
                for (Session session1 : websocketMap.values()) {
                    session1.getAsyncRemote().sendText(socketMsg.getMsg());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 实现服务器主动推送消息给用户
     */
    public void sendMessageByBackground(String message) {
        this.session.getAsyncRemote().sendText(message);
    }
}
