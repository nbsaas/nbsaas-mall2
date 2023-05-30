package com.nbsaas.life.area.api.domain.response;

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
public class AreaResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;

        //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date lastDate;

        private Float lat;

        private Integer sortNum;

        private Long id;

        private String code;

        private Integer lft;

        private Integer rgt;

        private Integer depth;

        private String name;

        private Float lng;

        private String ids;

        //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date addDate;


}