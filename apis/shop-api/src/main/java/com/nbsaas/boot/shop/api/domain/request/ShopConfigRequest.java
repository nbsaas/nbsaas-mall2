package com.nbsaas.boot.shop.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
/**
* 请求对象
*/
@Data
public class ShopConfigRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



        /**
        * 商家id
        **/
            private Long shop;

        /**
        * 配置json数据
        **/
            private String configData;

        /**
        * 商家id
        **/
            //private String shopNameName;

        /**
        * 配置类标识
        **/
            private String className;

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