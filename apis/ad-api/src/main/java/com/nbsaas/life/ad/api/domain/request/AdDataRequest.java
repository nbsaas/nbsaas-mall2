package com.nbsaas.life.ad.api.domain.request;

import com.nbsaas.boot.rest.request.RequestId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
* 请求对象
 */
@Data
public class AdDataRequest implements Serializable, RequestId {

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
        private String path;

        /**
         *
         **/
        private Date beginDate;

        /**
         *
         **/
        private Long bussId;

        /**
         *
         **/
        private String note;

        /**
         *
         **/
        private Integer catalog;

        /**
         * 添加时间
         **/
        private Date addDate;

        /**
         * 排序号
         **/
        private Integer sortNum;

        /**
         * 主键id
         **/
        private Long id;

        /**
         *
         **/
        private Long adPosition;

        /**
         *
         **/
        private String adPositionName;

        /**
         *
         **/
        private String url;

        /**
         *
         **/
        private String title;

        /**
         *
         **/
        private Date endDate;
}