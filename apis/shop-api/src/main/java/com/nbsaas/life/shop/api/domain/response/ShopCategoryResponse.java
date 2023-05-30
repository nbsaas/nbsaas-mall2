package com.nbsaas.life.shop.api.domain.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
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

        //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date lastDate;

        private Long nums;

        private String icon;

        private String pinyin;

        private String path;

        private String code;

        private Integer lft;

        private Integer depth;

        //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date addDate;

        private String py;

        private Integer sortNum;

        private Long id;

        private Integer rgt;

        private String name;

        private String ids;

        private String cname;


}