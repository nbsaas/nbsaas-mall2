package com.nbsaas.life.user.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
            import com.nbsaas.boot.rest.enums.StoreState;
            import com.nbsaas.life.user.api.domain.enums.LoginState;
/**
* 请求对象
*/
@Data
public class UserLoginLogDataRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        private StoreState storeState;
        private String password;
        private Long user;
        private String ip;
        private Date lastDate;
        private String userName;
        private Long id;
        private String client;
        private Date addDate;
        private String note;
        private String account;
        private LoginState state;
}