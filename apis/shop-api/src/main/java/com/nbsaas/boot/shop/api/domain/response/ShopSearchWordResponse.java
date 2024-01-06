package com.nbsaas.boot.shop.api.domain.response;

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
public class ShopSearchWordResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 商家id
        **/
            private Long shop;

        /**
        * 
        **/
            private Integer searchNum;

        /**
        * 
        **/
            private Integer searchType;

            private String searchTypeName;

        /**
        * 商家id
        **/
            private String shopName;

        /**
        * 
        **/
            private Long staff;

        /**
        * 排序号
        **/
            private Integer sortNum;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 搜索词
        **/
            private String word;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}