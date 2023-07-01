package com.nbsaas.boot.common.api.domain.response;

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
public class BillboardItemResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 
        **/
            private Integer score;

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
            private Float discount;

        /**
        * 
        **/
            private Integer sortNum;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 
        **/
            private Long billboard;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}