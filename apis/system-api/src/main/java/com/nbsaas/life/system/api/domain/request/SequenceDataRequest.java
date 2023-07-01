package com.nbsaas.life.system.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
/**
* 请求对象
*/
@Data
public class SequenceDataRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



        /**
        * 
        **/
            private Date updateDate;

        /**
        * 
        **/
            private String name;

        /**
        * 
        **/
            private Integer increment;

        /**
        * 
        **/
            private Long currentNum;

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
            private Date createDate;

        /**
        * 最新修改时间
        **/
            private Date lastDate;
}