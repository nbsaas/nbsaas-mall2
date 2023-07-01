package com.nbsaas.life.user.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
/**
* 请求对象
*/
@Data
public class UserOauthConfigDataRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



        /**
        * 第三方登陆名称
        **/
            private String name;

        /**
        * 第三方标识
        **/
            private String model;

        /**
        * 程序key
        **/
            private String appKey;

        /**
        * 程序密钥
        **/
            private String appSecret;

        /**
        * java实现类
        **/
            private String className;

        /**
        * 状态
        **/
            private Integer state;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 最新修改时间
        **/
            private Date lastDate;
}