package com.nbsaas.life.shop.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
/**
* 请求对象
*/
@Data
public class ShopCategoryDataRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        private String py;
        private Integer rgt;
        private Integer sortNum;
        private String cname;
        private Long id;
        private Date addDate;
        private Integer depth;
        private String code;
        private Long nums;
        private String pinyin;
        private String ids;
        private String path;
        private Date lastDate;
        private String icon;
        private Integer lft;
        private String name;
}