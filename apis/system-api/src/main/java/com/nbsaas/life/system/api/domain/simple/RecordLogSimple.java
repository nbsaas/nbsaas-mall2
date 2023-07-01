package com.nbsaas.life.system.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;

/**
* 列表对象
*/
@Data
public class RecordLogSimple implements Serializable {

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