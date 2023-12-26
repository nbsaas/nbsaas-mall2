package com.nbsaas.boot.ad.api.domain.simple;

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
            * 内容
            **/
                private String note;

            /**
            * 广告结束时间
            **/
                private Date endDate;

            /**
            * 分类
            **/
                private Integer catalog;

            /**
            * 广告名称
            **/
                private String title;

            /**
            * 添加时间
            **/
                private Date addDate;

            /**
            * 链接地址
            **/
                private String url;

            /**
            * 业务id
            **/
                private Long bussId;

            /**
            * 广告位
            **/
                private Long adPosition;

            /**
            * 广告图片
            **/
                private String path;

            /**
            * 广告开始时间
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
            * 广告位
            **/
                private String adPositionName;

            /**
            * 最新修改时间
            **/
                private Date lastDate;


}