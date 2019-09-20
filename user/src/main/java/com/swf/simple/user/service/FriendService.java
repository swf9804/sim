package com.swf.simple.user.service;

import com.swf.simple.common.pojo.UserInfoVO;
import com.swf.simple.common.pojo.UserVO;

import java.util.List;

/**
 * @author SWF
 * @date 2019/9/20 22:20
 **/
public interface FriendService {
    List<UserVO> listFriend();

    void establishRelations(Integer userId,Integer friendId);

}
