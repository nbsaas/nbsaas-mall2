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
public class BrandRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



        /**
        * 品牌介绍
        **/
            private String note;

        /**
        * 品牌名称
        **/
            private String name;

        /**
        * 品牌logo
        **/
            private String logo;

        /**
        * 
        **/
            private StoreState storeState;

        /**
        * 
        **/
            private Integer recommend;

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