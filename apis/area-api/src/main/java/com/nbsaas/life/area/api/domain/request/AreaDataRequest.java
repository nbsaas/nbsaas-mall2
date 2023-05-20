package com.nbsaas.life.area.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
/**
* 请求对象
*/
@Data
public class AreaDataRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        private Integer rgt;
        private String ids;
        private Float lat;
        private Date lastDate;
        private Float lng;
        private Integer sortNum;
        private Long id;
        private Integer lft;
        private Date addDate;
        private String name;
        private Integer depth;
        private String code;
}