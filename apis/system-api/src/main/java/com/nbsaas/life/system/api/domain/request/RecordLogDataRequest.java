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
public class RecordLogDataRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        private Date createDate;
        private String ip;
        private Date lastDate;
        private String title;
        private String app;
        private Long id;
        private Long createUser;
        private String data;
        private Date addDate;
        private String createName;
}