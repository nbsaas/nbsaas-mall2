package com.nbsaas.life.shop.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;

/**
* 列表对象
*/
@Data
public class ShopConfigSimple implements Serializable {

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
                private String shopName;

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