package com.nbsaas.life.system.api.domain.simple;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 列表对象
 */
@Data
public class DictSimple implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     * 字典名称
     **/
    private String title;

    /**
     * 最新修改时间
     **/
    private Date lastDate;

    /**
     * 主键id
     **/
    private Long id;

    /**
     * 字典key
     **/
    private String dictKey;

    /**
     * 添加时间
     **/
    private Date addDate;


}