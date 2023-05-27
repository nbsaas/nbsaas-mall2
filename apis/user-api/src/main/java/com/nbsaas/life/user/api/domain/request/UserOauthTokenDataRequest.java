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
public class UserOauthTokenDataRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        private String access_token;
        private Long expiresTime;
        private Long user;
        private Date lastDate;
        private String refresh_token;
        private String openId;
        private Long id;
        private Date addDate;
        private String tokenType;
        private Integer loginSize;
}