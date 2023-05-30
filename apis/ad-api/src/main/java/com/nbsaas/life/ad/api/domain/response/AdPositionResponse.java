package com.nbsaas.life.ad.api.domain.response;

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
public class AdPositionResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;

        //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date lastDate;

        private Integer sortNum;

        private String name;

        private String key;

        private Long id;

        private Integer height;

        private String note;

        private Integer width;

        private String template;

        //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date addDate;


}