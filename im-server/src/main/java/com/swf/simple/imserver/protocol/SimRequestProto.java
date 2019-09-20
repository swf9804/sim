package com.swf.simple.imserver.protocol;

import java.util.Date;

/**
 * @author SWF
 * @date 2019/9/19 16:25
 **/
public class SimRequestProto {
    /**
     * 消息id
     */
    private Long id;

    /**
     * 发送者
     */
    private Integer senderId;

    /**
     * 目的地类型
     */
    private DestType destType;
    /**
     * 目的地destination
     */
    private Integer destId;

    /**
     * 发送时间
     */
    private Date createTime;


    public enum DestType {
        SINGLE(0),
        GROUP(1);

        private int value;

        DestType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

}
