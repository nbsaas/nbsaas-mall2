package com.nbsaas.life.product.api.domain.response;

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
public class ProductSpecValueResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 
        **/
            private String productSpecName;

        /**
        * 
        **/
            private String name;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 
        **/
            private Long productSpec;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}