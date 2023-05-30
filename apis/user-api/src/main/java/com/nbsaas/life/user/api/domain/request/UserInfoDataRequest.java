package com.nbsaas.life.user.api.domain.request;

import com.nbsaas.boot.rest.enums.StoreState;
import com.nbsaas.boot.rest.request.RequestId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
* 请求对象
 */
@Data
public class UserInfoDataRequest implements Serializable, RequestId {

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
        private String avatar;

        /**
         *
         **/
        private Integer loginSize;

        /**
         *
         **/
        private String name;

        /**
         * 主键id
         **/
        private Long id;

        /**
         *
         **/
        private StoreState storeState;

        /**
         *
         **/
        private String phone;

        /**
         *
         **/
        private Integer catalog;

        /**
         * 添加时间
         **/
        private Date addDate;
}