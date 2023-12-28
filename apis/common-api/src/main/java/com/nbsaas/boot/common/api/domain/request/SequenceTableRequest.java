package com.nbsaas.boot.common.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
/**
* 请求对象
*/
@Data
public class SequenceTableRequest implements Serializable,RequestId {

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