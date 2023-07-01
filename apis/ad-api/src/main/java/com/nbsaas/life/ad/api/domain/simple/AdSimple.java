package com.nbsaas.life.ad.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;

/**
* 列表对象
*/
@Data
public class AdSimple implements Serializable {

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