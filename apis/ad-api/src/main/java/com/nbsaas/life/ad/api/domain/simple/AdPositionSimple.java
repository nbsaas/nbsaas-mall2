package com.nbsaas.life.ad.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;

/**
* 列表对象
*/
@Data
public class AdPositionSimple implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;




            /**
            * 模板
            **/
                private String template;

            /**
            * 描述
            **/
                private String note;

            /**
            * 广告位
            **/
                private String name;

            /**
            * 宽度
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
            * 标识
            **/
                private String key;

            /**
            * 高度
            **/
                private Integer height;

            /**
            * 最新修改时间
            **/
                private Date lastDate;


}