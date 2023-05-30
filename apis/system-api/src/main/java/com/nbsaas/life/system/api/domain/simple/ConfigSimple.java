package com.nbsaas.life.system.api.domain.simple;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* 列表对象
 */
@Data
public class ConfigSimple implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     * 最新修改时间
     **/
    private Date lastDate;

    /**
     * 主键id
     **/
    private Long id;

    /**
     *
     **/
    private String content;

    /**
     * 添加时间
     **/
    private Date addDate;


}