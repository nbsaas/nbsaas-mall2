package com.nbsaas.life.ad.api.domain.response;

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
public class AdPositionResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 
        **/
            private String template;

        /**
        * 
        **/
            private String note;

        /**
        * 
        **/
            private String name;

        /**
        * 
        **/
            private Integer width;

        /**
        * 排序号
        **/
            private Integer sortNum;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 
        **/
            private String key;

        /**
        * 
        **/
            private Integer height;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}