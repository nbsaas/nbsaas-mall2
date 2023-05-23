package com.nbsaas.life.system.api.domain.response;

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
public class ApplicationMenuResponse  implements Serializable {
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

            //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date addDate;

        private Integer depth;

        private String code;

        private Integer menuType;

        private String ids;

        private String path;

        private String permission;

            //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date lastDate;

        private Integer catalog;

        private String icon;

        private Long num;

        private Long app;

        private Integer lft;

        private String name;


}