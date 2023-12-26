package com.nbsaas.boot.talk.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
/**
* 请求对象
*/
@Data
public class TalkCategoryRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



        /**
        * 
        **/
            private String path;

        /**
        * 编码
        **/
            private String code;

        /**
        * 深度
        **/
            private Integer depth;

        /**
        * 
        **/
            private String icon;

        /**
        * 名称
        **/
            private String name;

        /**
        * ids
        **/
            private String ids;

        /**
        * 排序号
        **/
            private Integer sortNum;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 左节点
        **/
            private Integer lft;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 右节点
        **/
            private Integer rgt;

        /**
        * 最新修改时间
        **/
            private Date lastDate;
}