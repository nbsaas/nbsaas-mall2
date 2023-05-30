package com.nbsaas.life.user.api.domain.response;

import com.nbsaas.boot.rest.enums.StoreState;
import com.nbsaas.life.user.api.domain.enums.LoginState;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
/**
* 响应对象
 */
@Getter
@Setter
@ToString(callSuper = true)
public class UserLoginLogResponse implements Serializable {
        /**
         * 序列化参数
         */
        private static final long serialVersionUID = 1L;

        private String note;

        //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date lastDate;

        private LoginState state;

        private Long id;

        private StoreState storeState;

        private String account;

        private Long user;

        private String password;

        private String ip;

        private String userName;

        private String client;

        //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date addDate;


}