package com.nbsaas.life.ad.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;

/**
* 列表对象
*/
@Data
public class AdPositionSimple implements Serializable {

    /**
    * 序列化参数
    */
    private static final long serialVersionUID = 1L;


            private Integer height;
                //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
            private Date lastDate;
            private Integer width;
            private Integer sortNum;
            private Long id;
                //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
            private Date addDate;
            private String key;
            private String note;
            private String name;
            private String template;


}