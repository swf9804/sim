package com.swf.simple.user.controller;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author SWF
 * @date 2019/9/14 22:00
 **/
@ServerEndpoint("/websocket")
@Component
public class WebSocketController {
    // 用来存放每个客户端对应的MyWebSocket对象
    private static Map<Integer,WebSocketController> webSocketControllers = new ConcurrentHashMap<>();

    private Session session;

    @OnOpen
    public void onOpen(Session session) {

        this.session = session;

        webSocketControllers.put(111,this);

        System.out.println("有新连接加入! 当前在线人数为" + webSocketControllers.size());

        this.session.getAsyncRemote().sendText("恭喜您成功连接上WebSocket --> 当前在线人数");
    }

    @OnClose
    public void onClose() {
        webSocketControllers.remove(this);
        System.out.println("有一个连接关闭！当前在线人数为" + webSocketControllers.size());
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

}
