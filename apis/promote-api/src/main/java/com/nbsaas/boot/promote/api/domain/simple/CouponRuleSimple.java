package com.nbsaas.boot.promote.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
            import com.nbsaas.boot.rest.enums.StoreState;

/**
* 列表对象
*/
@Data
public class CouponRuleSimple implements Serializable {

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