package com.nbsaas.life.shop.api.domain.request;

import com.nbsaas.boot.rest.request.RequestId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
* 请求对象
 */
@Data
public class ShopCategoryDataRequest implements Serializable, RequestId {

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
        private Long nums;

        /**
         *
         **/
        private String icon;

        /**
         *
         **/
        private String pinyin;

        /**
         *
         **/
        private String path;

        /**
         * 编码
         **/
        private String code;

        /**
         * 左节点
         **/
        private Integer lft;

        /**
         * 深度
         **/
        private Integer depth;

        /**
         * 添加时间
         **/
        private Date addDate;

        /**
         *
         **/
        private String py;

        /**
         * 排序号
         **/
        private Integer sortNum;

        /**
         * 主键id
         **/
        private Long id;

        /**
         * 右节点
         **/
        private Integer rgt;

        /**
         * 名称
         **/
        private String name;

        /**
         * ids
         **/
        private String ids;

        /**
         *
         **/
        private String cname;
}