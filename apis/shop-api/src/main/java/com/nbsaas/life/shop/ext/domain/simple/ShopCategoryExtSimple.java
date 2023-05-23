package com.nbsaas.life.shop.ext.domain.simple;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 列表对象
 */
@Data
public class ShopCategoryExtSimple implements Serializable {


    private Integer sortNum;
    private Long id;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Integer depth;
    private String path;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date lastDate;
    private String icon;
    private String name;

    private String cname;

}