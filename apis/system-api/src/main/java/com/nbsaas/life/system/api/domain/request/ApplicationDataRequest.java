package com.nbsaas.life.system.api.domain.request;

import com.nbsaas.boot.rest.request.RequestId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 请求对象
 */
@Data
public class ApplicationDataRequest implements Serializable, RequestId {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     * 最新修改时间
     **/
        private Date lastDate;

    /**
     * 应用key
     **/
        private String appKey;

    /**
     * 应用名称
     **/
        private String name;

    /**
     * 主键id
     **/
        private Long id;

    /**
     * 应用介绍
     **/
        private String note;

    /**
     * 添加时间
     **/
        private Date addDate;
}