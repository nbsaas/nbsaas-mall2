package com.nbsaas.life.talk.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import lombok.Data;

/**
* 列表对象
 */
@Data
public class TalkSimple implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     *
     **/
    private Integer replies;

    /**
     * 最新修改时间
     **/
    private Date lastDate;

    /**
     *
     **/
    private String topic;

    /**
     * 主键id
     **/
    private Long id;

    /**
     *
     **/
    private String message;

    /**
     *
     **/
    private Integer subscribe;

    /**
     *
     **/
    private String lastMessage;

    /**
     * 添加时间
     **/
    private Date addDate;


}