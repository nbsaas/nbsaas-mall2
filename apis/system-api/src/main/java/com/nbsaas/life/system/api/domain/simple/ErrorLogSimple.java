package com.nbsaas.life.system.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;

/**
* 列表对象
*/
@Data
public class ErrorLogSimple implements Serializable {

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
                private String note;

            /**
            * 
            **/
                private String param;

            /**
            * 
            **/
                private String name;

            /**
            * 
            **/
                private String serverName;

            /**
            * 主键id
            **/
                private Long id;

            /**
            * 添加时间
            **/
                private Date addDate;

            /**
            * 
            **/
                private String url;

            /**
            * 最新修改时间
            **/
                private Date lastDate;


}