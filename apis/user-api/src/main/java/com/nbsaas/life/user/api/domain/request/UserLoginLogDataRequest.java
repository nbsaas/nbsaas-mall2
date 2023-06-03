package com.nbsaas.life.user.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
import com.nbsaas.life.user.api.domain.enums.LoginState;
import com.nbsaas.boot.rest.enums.StoreState;

/**
 * 请求对象
 */
@Data
public class UserLoginLogDataRequest implements Serializable, RequestId {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     * 备注
     **/
        private String note;

    /**
     * 最新修改时间
     **/
        private Date lastDate;

    /**
     *
     **/
        private LoginState state;

    /**
     * 主键id
     **/
        private Long id;

    /**
     *
     **/
        private StoreState storeState;

    /**
     * 登陆账号
     **/
        private String account;

    /**
     * 用户id
     **/
        private Long user;

    /**
     * 登录密码
     **/
        private String password;

    /**
     * 登录IP
     **/
        private String ip;

    /**
     * 用户id
     **/
        private String userName;

    /**
     * 客户端
     **/
        private String client;

    /**
     * 添加时间
     **/
        private Date addDate;
}