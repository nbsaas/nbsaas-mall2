package com.nbsaas.life.talk.api.domain.response;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
* 响应对象
*/
@Getter
@Setter
@ToString(callSuper = true)
public class TalkResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 
        **/
            private Integer replies;

        /**
        * 
        **/
            private Integer subscribe;

        /**
        * 
        **/
            private String lastMessage;

        /**
        * 
        **/
            private String topic;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 
        **/
            private String message;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}