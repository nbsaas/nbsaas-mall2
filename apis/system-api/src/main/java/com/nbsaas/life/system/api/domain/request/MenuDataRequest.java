package com.nbsaas.life.system.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
/**
* 请求对象
*/
@Data
public class MenuDataRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



        /**
        * 
        **/
            private Long parent;

        /**
        * 编码
        **/
            private String code;

        /**
        * 菜单类型
        **/
            private Integer catalog;

        /**
        * 
        **/
            private String icon;

        /**
        * 
        **/
            private String permission;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 
        **/
            private String path;

        /**
        * 
        **/
            private String router;

        /**
        * 深度
        **/
            private Integer depth;

        /**
        * 名称
        **/
            private String name;

        /**
        * ids
        **/
            private String ids;

        /**
        * 是否租户使用
        **/
            private Integer menuType;

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
        * 
        **/
            private Long nums;

        /**
        * 右节点
        **/
            private Integer rgt;

        /**
        * 最新修改时间
        **/
            private Date lastDate;
}