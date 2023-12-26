package com.nbsaas.boot.talk.api.domain.request;

import com.nbsaas.boot.rest.filter.Operator;
import com.nbsaas.boot.rest.filter.Search;
import com.nbsaas.boot.rest.request.PageRequest;
import lombok.*;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
* 搜索bean
*/
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TalkReplySearch   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



            /**
            * 
            **/
            @Search(name = "replies",operator = Operator.eq)
            private Integer replies;

            /**
            * 
            **/
            @Search(name = "subscribe",operator = Operator.eq)
            private Integer subscribe;

            /**
            * 
            **/
            @Search(name = "topic",operator = Operator.like)
            private String topic;

            /**
            * 主键id
            **/
            @Search(name = "id",operator = Operator.eq)
            private Long id;

            /**
            * 
            **/
            @Search(name = "message",operator = Operator.like)
            private String message;



}