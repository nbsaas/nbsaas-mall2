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
public class AdResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 
        **/
            private String note;

        /**
        * 
        **/
            private Date endDate;

        /**
        * 
        **/
            private Integer catalog;

        /**
        * 
        **/
            private String title;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 
        **/
            private String url;

        /**
        * 
        **/
            private Long bussId;

        /**
        * 
        **/
            private Long adPosition;

        /**
        * 
        **/
            private String path;

        /**
        * 
        **/
            private Date beginDate;

        /**
        * 排序号
        **/
            private Integer sortNum;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 
        **/
            private String adPositionName;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}