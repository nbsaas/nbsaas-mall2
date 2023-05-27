package com.nbsaas.life.user.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
            import com.nbsaas.life.user.api.domain.enums.SecurityType;
/**
* 请求对象
*/
@Data
public class UserPasswordDataRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        private String password;
        private Long user;
        private Date lastDate;
        private SecurityType securityType;
        private String salt;
        private Long id;
        private Date addDate;
        private Integer checkSize;
}