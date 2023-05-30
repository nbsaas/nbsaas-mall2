package com.nbsaas.life.talk.api.domain.request;

import com.nbsaas.boot.rest.request.RequestId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
* 请求对象
 */
@Data
public class TalkDataRequest implements Serializable, RequestId {

        /**
         * 序列化参数
         */
        private static final long serialVersionUID = 1L;


        /**
         *
         **/
        private Integer replies;

        /**
         * 最新修改时间
         **/
        private Date lastDate;

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
         *
         **/
        private Integer subscribe;

        /**
         *
         **/
        private String lastMessage;

        /**
         * 添加时间
         **/
        private Date addDate;
}