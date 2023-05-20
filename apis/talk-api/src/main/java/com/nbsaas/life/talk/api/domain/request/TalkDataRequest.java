package com.nbsaas.life.talk.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
/**
* 请求对象
*/
@Data
public class TalkDataRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        private Integer replies;
        private String lastMessage;
        private Date lastDate;
        private Integer subscribe;
        private String message;
        private Long id;
        private Date addDate;
        private String topic;
}