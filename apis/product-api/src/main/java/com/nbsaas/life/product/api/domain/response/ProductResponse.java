package com.nbsaas.life.product.api.domain.response;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
            import com.nbsaas.boot.rest.enums.StoreState;
/**
* 响应对象
*/
@Getter
@Setter
@ToString(callSuper = true)
public class ProductResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 
        **/
            private String summary;

        /**
        * 
        **/
            private String thumbnail;

        /**
        * 
        **/
            private Long shop;

        /**
        * 
        **/
            private Date stockDate;

        /**
        * 
        **/
            private BigDecimal discount;

        /**
        * 
        **/
            private BigDecimal mealFee;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 
        **/
            private Boolean skuEnable;

        /**
        * 
        **/
            private String barCode;

        /**
        * 
        **/
            private BigDecimal price;

        /**
        * 
        **/
            private BigDecimal minPrice;

        /**
        * 
        **/
            private String name;

        /**
        * 
        **/
            private Long stockNum;

        /**
        * 
        **/
            private Long realStock;

        /**
        * 
        **/
            private String logo;

        /**
        * 
        **/
            //枚举
            private StoreState storeState;

            private String storeStateName;

        /**
        * 
        **/
            private BigDecimal maxPrice;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}