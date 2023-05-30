package com.nbsaas.life.user.api.domain.request;

import com.nbsaas.boot.rest.request.RequestId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
* 请求对象
 */
@Data
public class UserOauthConfigDataRequest implements Serializable, RequestId {

        /**
         * 序列化参数
         */
        private static final long serialVersionUID = 1L;


        /**
         * 最新修改时间
         **/
        private Date lastDate;

        /**
         * 程序密钥
         **/
        private String appSecret;

        /**
         * java实现类
         **/
        private String className;

        /**
         * 程序key
         **/
        private String appKey;

        /**
         * 主键id
         **/
        private Long id;

        /**
         * 状态
         **/
        private Integer state;

        /**
         * 第三方标识
         **/
        private String model;

        /**
         * 第三方登陆名称
         **/
        private String name;

        /**
         * 添加时间
         **/
        private Date addDate;
}