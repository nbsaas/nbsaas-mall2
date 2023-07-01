package com.nbsaas.life.system.api.domain.response;

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
public class SequenceResponse  implements Serializable {
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