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


        private Integer height;
        private Date lastDate;
        private Integer width;
        private Integer sortNum;
        private Long id;
        private Date addDate;
        private String key;
        private String note;
        private String name;
        private String template;
}