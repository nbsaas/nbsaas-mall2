package com.nbsaas.life.system.api.domain.response;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
* 响应对象
*/
@Getter
@Setter
@ToString(callSuper = true)
public class RecordLogResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 
        **/
            private String app;

        /**
        * 
        **/
            private String data;

        /**
        * 
        **/
            private String ip;

        /**
        * 
        **/
            private Long createUser;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 
        **/
            private String title;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 
        **/
            private String createName;

        /**
        * 
        **/
            private Date createDate;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}