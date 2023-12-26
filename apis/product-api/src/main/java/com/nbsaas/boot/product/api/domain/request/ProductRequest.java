package com.nbsaas.boot.product.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
            import com.nbsaas.boot.rest.enums.StoreState;
/**
* 请求对象
*/
@Data
public class ProductRequest implements Serializable,RequestId {

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
            private StoreState storeState;

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