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


        private Date createDate;
        private Long currentNum;
        private Date lastDate;
        private Long id;
        private Date addDate;
        private String name;
        private Integer increment;
        private Date updateDate;
}