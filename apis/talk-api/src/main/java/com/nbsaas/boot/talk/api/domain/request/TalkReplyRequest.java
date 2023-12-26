package com.nbsaas.boot.talk.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
/**
* 请求对象
*/
@Data
public class TalkReplyRequest implements Serializable,RequestId {

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