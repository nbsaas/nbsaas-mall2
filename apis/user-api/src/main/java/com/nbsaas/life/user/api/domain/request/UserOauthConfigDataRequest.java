package com.nbsaas.life.user.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
/**
* 请求对象
*/
@Data
public class UserOauthConfigDataRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        private String model;
        private String appSecret;
        private Date lastDate;
        private Long id;
        private Date addDate;
        private Integer state;
        private String name;
        private String appKey;
        private String className;
}