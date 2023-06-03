package com.nbsaas.life.area.api.domain.request;

import com.nbsaas.boot.rest.request.RequestId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 请求对象
 */
@Data
public class AreaDataRequest implements Serializable, RequestId {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     * 最新修改时间
     **/
        private Date lastDate;

    /**
     *
     **/
        private Float lat;

    /**
     * 排序号
     **/
        private Integer sortNum;

    /**
     * 主键id
     **/
        private Long id;

    /**
     * 编码
     **/
        private String code;

    /**
     * 左节点
     **/
        private Integer lft;

    /**
     * 右节点
     **/
        private Integer rgt;

    /**
     * 深度
     **/
        private Integer depth;

    /**
     * 名称
     **/
        private String name;

    /**
     *
     **/
        private Float lng;

    /**
     * ids
     **/
        private String ids;

    /**
     * 添加时间
     **/
        private Date addDate;
}