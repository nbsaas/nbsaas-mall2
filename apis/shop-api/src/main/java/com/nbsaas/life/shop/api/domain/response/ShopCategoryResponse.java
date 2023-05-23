package com.nbsaas.life.shop.api.domain.response;

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
public class ShopCategoryResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;

        private String py;

        private Integer rgt;

        private Integer sortNum;

        private String cname;

        private Long id;

            //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date addDate;

        private Integer depth;

        private String code;

        private Long nums;

        private String pinyin;

        private String ids;

        private String path;

            //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date lastDate;

        private String icon;

        private Integer lft;

        private String name;


}