package com.swf.simple.user.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springboot.framework.annotation.ACS;
import com.springboot.framework.config.WechatAccountConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author SWF
 * @Date 2019/4/19 16:17
 **/
@Component
public class WeixinUtil {

    @Autowired
    private WechatAccountConfig wechatAccountConfig;

    @Autowired
    private RedisUtil redisUtil;

    private Log logger = LogFactory.getLog(WeixinUtil.class);

    @ACS(allowAnonymous = true)
    public String getWeiXinTicket() throws Exception {
        String accessToken = "";
        String ticket = "";
        Object accessTokenCache = redisUtil.get(wechatAccountConfig.getAppName() + "_access_token");
        Object apiTicketCache = redisUtil.get(wechatAccountConfig.getAppName() + "_api_ticket");
        logger.debug("[act] = " + accessTokenCache + " [apiticket] = " + apiTicketCache);
        if (null == accessTokenCache) {

            String url = "https://api.weixin.qq.com/cgi-bin/token";
            String jsonStrToken = ToolsUtil.sendGet(url, "grant_type=client_credential&appid="+ wechatAccountConfig.getMpAppId() + "&secret=" + wechatAccountConfig.getMpAppSecret());
            logger.debug("[jsonStrToken] = " + jsonStrToken);

            JSONObject json = JSON.parseObject(jsonStrToken);
            accessToken = json.getString("access_token");
            if (accessToken == null) {
                return null;
            }
            redisUtil.set(wechatAccountConfig.getAppName() + "_access_token",accessToken,7200);
        } else {
            accessToken = (String) accessTokenCache;
        }

        if (null == apiTicketCache) {
            String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";
            String jsonStrTicket = ToolsUtil.sendGet(url, "access_token=" + accessToken + "&type=jsapi");

            logger.debug("[jsonStrTicket] = " + jsonStrTicket);

            JSONObject json = JSON.parseObject(jsonStrTicket);
            ticket = (String) json.getString("ticket");
            redisUtil.set(wechatAccountConfig.getAppName() + "_api_ticket",ticket,7200);

        } else {
            ticket = (String) apiTicketCache;
        }

        return ticket;
        // 断开连接

    }

}
