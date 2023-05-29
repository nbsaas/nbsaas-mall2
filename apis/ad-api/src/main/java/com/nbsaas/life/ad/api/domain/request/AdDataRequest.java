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
public class AdDataRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        private String url;
        private String title;
        private Integer sortNum;
        private Long id;
        private Date addDate;
        private Date endDate;
        private String adPositionName;
        private Long bussId;
        private Date beginDate;
        private String path;
        private Date lastDate;
        private Integer catalog;
        private String note;
        private Long adPosition;
}