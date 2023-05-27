package com.nbsaas.life.user.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;

/**
* 列表对象
*/
@Data
public class UserOauthConfigSimple implements Serializable {

    /**
    * 序列化参数
    */
    private static final long serialVersionUID = 1L;


            private String model;
            private String appSecret;
                //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
            private Date lastDate;
            private Long id;
                //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
            private Date addDate;
            private Integer state;
            private String name;
            private String appKey;
            private String className;


}