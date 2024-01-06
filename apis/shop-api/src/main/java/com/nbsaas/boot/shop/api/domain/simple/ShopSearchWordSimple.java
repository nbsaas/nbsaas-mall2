package com.nbsaas.boot.shop.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;

/**
* 列表对象
*/
@Data
public class ShopSearchWordSimple implements Serializable {

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