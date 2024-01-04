package com.nbsaas.boot.order.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.nbsaas.boot.order.ext.domain.simple.OrderExt;
import lombok.Data;

/**
* 列表对象
*/
@Data
public class OrderSimple implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;




            /**
            * 
            **/
                private Integer sourceClient;

                private String sourceClientName;

            /**
            * 
            **/
                private Integer catalog;

                private String catalogName;

            /**
            * 
            **/
                private Integer state;

                private String stateName;

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

    private OrderExt orderExt;

}