package com.nbsaas.life.product.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;

/**
* 列表对象
*/
@Data
public class ProductSpecSimple implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;




            /**
            * 
            **/
                private Long product;

            /**
            * 
            **/
                private String name;

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