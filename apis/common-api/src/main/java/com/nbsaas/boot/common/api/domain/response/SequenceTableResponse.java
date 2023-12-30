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
public class SequenceTableResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 
        **/
            private String name;

        /**
        * 
        **/
            private Integer step;

        /**
        * 主键id
        **/
            private String id;

        /**
        * 
        **/
            private Long value;

}