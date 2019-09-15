package com.swf.simple.imserver.controller;

import com.swf.simple.imserver.util.ConnectionHolder;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author SWF
 * @date 2019/9/14 22:00
 **/
@ServerEndpoint("/websocket/{token}")
@Component
@Log4j2
public class WebSocketController {

    private Session session;

    @OnOpen
    public void onOpen(Session session) {

        this.session = session;

        ConnectionHolder.put(111, this);

        log.info("有新连接加入! 当前在线人数为{}",ConnectionHolder.size());

        sendText("恭喜你，连接成功，当前在线人数："+ ConnectionHolder.size());
    }

    @OnClose
    public void onClose() {
        ConnectionHolder.remove(this);
        log.info("有一个连接关闭! 当前在线人数为{}",ConnectionHolder.size());
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("来自客户端的消息：" + message);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");

        error.printStackTrace();
    }

//    /**
//     * 群发自定义消息
//     * @param message
//     */
//    public void broadcast(String message) {
//        for (WebSocketController item : webSocketControllers) {
//            // 异步发送消息
//            item.session.getAsyncRemote().sendText(message);
//        }
//    }

    public void sendText(String text){
        this.session.getAsyncRemote().sendText(text);
    }

}
