package com.nbsaas.life.user.api.domain.response;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.nbsaas.boot.rest.enums.StoreState;

/**
 * 响应对象
 */
@Getter
@Setter
@ToString(callSuper = true)
public class UserInfoResponse implements Serializable {
    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date lastDate;

    private String avatar;

    private Integer loginSize;

    private String name;

        private Long id;

        private StoreState storeState;

        private String phone;

        private Integer catalog;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date addDate;


}