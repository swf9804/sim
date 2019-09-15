package com.swf.simple.imserver.util;

import com.swf.simple.imserver.controller.WebSocketController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author SWF
 * @date 2019/9/15 22:44
 **/
public class ConnectionHolder {

    private static final Map<Integer, WebSocketController> CONTROLLER_MAP = new ConcurrentHashMap<>(20);

    public static void put(Integer userId,WebSocketController webSocketController){
        CONTROLLER_MAP.put(userId,webSocketController);
    }

    public static WebSocketController get(Integer userId){
        return CONTROLLER_MAP.get(userId);
    }

    public static void remove(Integer userId){
        CONTROLLER_MAP.remove(userId);
    }

    public static void remove(final WebSocketController webSocketController){
        CONTROLLER_MAP.entrySet().stream()
                .filter(entry -> entry.getValue() == webSocketController)
                .forEach(entry -> CONTROLLER_MAP.remove(entry.getKey()));
    }

    public static int size(){
        return CONTROLLER_MAP.size();
    }
}
