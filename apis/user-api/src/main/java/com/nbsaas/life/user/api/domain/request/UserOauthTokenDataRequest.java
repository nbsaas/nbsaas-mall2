package com.nbsaas.life.user.api.domain.request;

import com.nbsaas.boot.rest.request.RequestId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 请求对象
 */
@Data
public class UserOauthTokenDataRequest implements Serializable, RequestId {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     * 用户openId
     **/
        private String openId;

    /**
     * 最新修改时间
     **/
        private Date lastDate;

    /**
     * 过期时间
     **/
        private Long expiresTime;

    /**
     * 主键id
     **/
        private Long id;

    /**
     * 用户id
     **/
        private Long user;

    /**
     * 刷新token
     **/
        private String refresh_token;

    /**
     * token类型
     **/
        private String tokenType;

    /**
     * 访问token
     **/
        private String access_token;

    /**
     * 登录次数
     **/
        private Integer loginSize;

    /**
     * 添加时间
     **/
        private Date addDate;
}