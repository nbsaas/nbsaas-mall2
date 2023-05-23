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
public class ApplicationMenuDataRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        private String router;
        private Integer rgt;
        private String appName;
        private Integer sortNum;
        private Long creator;
        private Long id;
        private Date addDate;
        private Integer depth;
        private String code;
        private Integer menuType;
        private String ids;
        private String path;
        private String permission;
        private Date lastDate;
        private Integer catalog;
        private String icon;
        private Long num;
        private Long app;
        private Integer lft;
        private String name;
}