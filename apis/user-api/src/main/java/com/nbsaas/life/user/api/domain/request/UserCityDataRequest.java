package com.nbsaas.life.user.api.domain.request;

import com.nbsaas.boot.rest.request.RequestId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
* 请求对象
 */
@Data
public class UserCityDataRequest implements Serializable, RequestId {

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
        private Integer state;

        /**
         * 主键id
         **/
        private Long id;

        /**
         * 所在地址
         **/
        private String address;

        /**
         * 地点的名称
         **/
        private String name;

        /**
         * 添加时间
         **/
        private Date addDate;
}