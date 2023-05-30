package com.nbsaas.life.user.api.domain.response;

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
public class UserOauthConfigResponse implements Serializable {
        /**
         * 序列化参数
         */
        private static final long serialVersionUID = 1L;

        //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date lastDate;

        private String appSecret;

        private String className;

        private String appKey;

        private Long id;

        private Integer state;

        private String model;

        private String name;

        //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date addDate;


}