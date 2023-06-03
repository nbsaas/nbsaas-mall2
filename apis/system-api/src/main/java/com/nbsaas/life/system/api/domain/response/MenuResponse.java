package com.nbsaas.life.system.api.domain.response;

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
public class MenuResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date lastDate;

        private String icon;

        private Long nums;

        private String path;

        private String code;

        private Integer lft;

        private Integer depth;

        private String permission;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date addDate;

        private Integer sortNum;

        private Long parent;

        private String router;

        private Long id;

        private Integer catalog;

        private Integer menuType;

        private Integer rgt;

        private String name;

        private String ids;


}