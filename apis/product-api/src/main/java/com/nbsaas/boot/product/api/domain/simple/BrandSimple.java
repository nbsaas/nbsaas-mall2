package com.nbsaas.boot.product.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
            import com.nbsaas.boot.rest.enums.StoreState;

/**
* 列表对象
*/
@Data
public class BrandSimple implements Serializable {

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

                private String storeStateName;

            /**
            * 
            **/
                private Integer recommend;

                private String recommendName;

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