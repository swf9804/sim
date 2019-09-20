package com.swf.simple.user.controller;

import com.swf.simple.user.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SWF
 * @date 2019/9/20 22:19
 **/
@RestController
@RequestMapping("/friend")
public class FriendController {


    private FriendService friendService;

    public void listFriend(){

    }

    public void listOnlineFriend(){

    }


}
