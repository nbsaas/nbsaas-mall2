package com.nbsaas.boot.common.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;

/**
* 列表对象
*/
@Data
public class BillboardItemSimple implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



            /**
            * 
            **/
                private Integer score;

            /**
            * 
            **/
                private String name;

            /**
            * 
            **/
                private String logo;

            /**
            * 
            **/
                private Float discount;

            /**
            * 
            **/
                private Integer sortNum;

            /**
            * 主键id
            **/
                private Long id;

            /**
            * 
            **/
                private Long billboard;

            /**
            * 添加时间
            **/
                private Date addDate;

            /**
            * 最新修改时间
            **/
                private Date lastDate;


}