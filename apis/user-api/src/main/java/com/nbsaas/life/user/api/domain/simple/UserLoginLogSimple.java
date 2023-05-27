package com.nbsaas.life.user.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
            import com.nbsaas.boot.rest.enums.StoreState;
            import com.nbsaas.life.user.api.domain.enums.LoginState;

/**
* 列表对象
*/
@Data
public class UserLoginLogSimple implements Serializable {

    /**
    * 序列化参数
    */
    private static final long serialVersionUID = 1L;


            private StoreState storeState;
            private String password;
            private Long user;
            private String ip;
                //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
            private Date lastDate;
            private String userName;
            private Long id;
            private String client;
                //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
            private Date addDate;
            private String note;
            private String account;
            private LoginState state;


}