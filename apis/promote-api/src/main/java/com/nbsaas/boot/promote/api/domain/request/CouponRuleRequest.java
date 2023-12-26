package com.nbsaas.boot.promote.api.domain.request;

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
public class CouponRuleRequest implements Serializable,RequestId {

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
            //private String shopNameName;

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