package com.nbsaas.life.product.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
/**
* 请求对象
*/
@Data
public class ProductSpecValueRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



        /**
        * 
        **/
            //private String productSpecNameName;

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