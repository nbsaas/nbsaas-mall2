package com.nbsaas.life.ad.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
/**
* 请求对象
*/
@Data
public class AdPositionDataRequest implements Serializable,RequestId {

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