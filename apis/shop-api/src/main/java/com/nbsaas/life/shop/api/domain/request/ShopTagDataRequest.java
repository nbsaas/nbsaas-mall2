package com.nbsaas.life.shop.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;

/**
 * 请求对象
 */
@Data
public class ShopTagDataRequest implements Serializable, RequestId {

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
     * 使用的店铺标签数量
     **/
        private Integer size;

    /**
     * 商家标签名称
     **/
        private String name;

    /**
     * 添加时间
     **/
        private Date addDate;
}