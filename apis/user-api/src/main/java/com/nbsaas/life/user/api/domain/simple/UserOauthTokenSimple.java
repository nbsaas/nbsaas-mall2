package com.nbsaas.life.user.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;

/**
* 列表对象
*/
@Data
public class UserOauthTokenSimple implements Serializable {

    /**
    * 序列化参数
    */
    private static final long serialVersionUID = 1L;


            private String access_token;
            private Long expiresTime;
            private Long user;
                //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
            private Date lastDate;
            private String refresh_token;
            private String openId;
            private Long id;
                //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
            private Date addDate;
            private String tokenType;
            private Integer loginSize;


}