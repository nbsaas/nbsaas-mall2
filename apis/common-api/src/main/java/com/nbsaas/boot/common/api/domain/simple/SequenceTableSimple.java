package com.nbsaas.boot.common.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;

/**
* 列表对象
*/
@Data
public class SequenceTableSimple implements Serializable {

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