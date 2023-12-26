package com.nbsaas.boot.promote.api.domain.response;

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
public class CouponRuleResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 
        **/
            private Integer limitNum;

        /**
        * 
        **/
            private String note;

        /**
        * 
        **/
            private Long shop;

        /**
        * 
        **/
            private String shopName;

        /**
        * 
        **/
            private Date sendBeginTime;

        /**
        * 
        **/
            private Date useBeginTime;

        /**
        * 
        **/
            private Date useEndTime;

        /**
        * 
        **/
            private Short couponScope;

        /**
        * 
        **/
            private Integer takeawayRate;

        /**
        * 
        **/
            private BigDecimal money;

        /**
        * 
        **/
            private Long useNum;

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
            private String logo;

        /**
        * 
        **/
            //枚举
            private StoreState storeState;

            private String storeStateName;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 
        **/
            private Integer stock;

        /**
        * 
        **/
            private Long sendNum;

        /**
        * 
        **/
            private Date sendEndTime;

        /**
        * 
        **/
            private Integer useDay;

}