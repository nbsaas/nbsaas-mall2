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
public class ApplicationMenuResponse implements Serializable {
    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date lastDate;

    private String code;

    private Integer lft;

    private Integer depth;

        private String router;

        private Integer catalog;

        private Long num;

        private String icon;

        private String appName;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date addDate;

        private Integer sortNum;

        private Long app;

        private Long id;

        private Integer menuType;

        private Integer rgt;

        private Long creator;

        private String name;

        private String permission;

        private String path;

        private String ids;


}