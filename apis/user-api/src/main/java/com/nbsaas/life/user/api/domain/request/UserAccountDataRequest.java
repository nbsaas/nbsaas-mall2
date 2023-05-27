package com.nbsaas.life.user.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
            import com.nbsaas.life.user.api.domain.enums.AccountType;
/**
* 请求对象
*/
@Data
public class UserAccountDataRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        private String username;
        private AccountType accountType;
        private Long user;
        private Date lastDate;
        private Long id;
        private Date addDate;
        private Integer loginSize;
}