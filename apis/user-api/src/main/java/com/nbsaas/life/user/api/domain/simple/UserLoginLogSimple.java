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
                private StoreState storeState;

                private String storeStateName;

            /**
            * 
            **/
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