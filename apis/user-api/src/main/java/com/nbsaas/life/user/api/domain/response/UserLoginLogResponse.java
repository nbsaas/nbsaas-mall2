package com.nbsaas.life.user.api.domain.response;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
            import com.nbsaas.boot.rest.enums.StoreState;
            import com.nbsaas.life.user.api.domain.enums.LoginState;
/**
* 响应对象
*/
@Getter
@Setter
@ToString(callSuper = true)
public class UserLoginLogResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 备注
        **/
            private String note;

        /**
        * 登录密码
        **/
            private String password;

        /**
        * 登录IP
        **/
            private String ip;

        /**
        * 客户端
        **/
            private String client;

        /**
        * 
        **/
            //枚举
            private StoreState storeState;

            private String storeStateName;

        /**
        * 
        **/
            //枚举
            private LoginState state;

            private String stateName;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 用户id
        **/
            private String userName;

        /**
        * 用户id
        **/
            private Long user;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 登陆账号
        **/
            private String account;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}