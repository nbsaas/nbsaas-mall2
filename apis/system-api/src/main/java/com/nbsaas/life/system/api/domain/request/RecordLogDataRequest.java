package com.nbsaas.life.system.api.domain.request;

import com.nbsaas.boot.rest.request.RequestId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
* 请求对象
 */
@Data
public class RecordLogDataRequest implements Serializable, RequestId {

        /**
         * 序列化参数
         */
        private static final long serialVersionUID = 1L;


        /**
         *
         **/
        private Date createDate;

        /**
         * 最新修改时间
         **/
        private Date lastDate;

        /**
         *
         **/
        private String createName;

        /**
         * 主键id
         **/
        private Long id;

        /**
         *
         **/
        private String app;

        /**
         *
         **/
        private Long createUser;

        /**
         *
         **/
        private String data;

        /**
         *
         **/
        private String title;

        /**
         *
         **/
        private String ip;

        /**
         * 添加时间
         **/
        private Date addDate;
}