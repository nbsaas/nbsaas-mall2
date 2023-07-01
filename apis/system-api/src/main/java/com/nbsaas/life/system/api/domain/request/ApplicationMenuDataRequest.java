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
public class ApplicationMenuDataRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



        /**
        * 应用
        **/
            private Long app;

        /**
        * 创建人id
        **/
            private Long creator;

        /**
        * 编码
        **/
            private String code;

        /**
        * 分类
        **/
            private Integer catalog;

        /**
        * 应用
        **/
            //private String appNameName;

        /**
        * 
        **/
            private Long num;

        /**
        * 图标
        **/
            private String icon;

        /**
        * 权限
        **/
            private String permission;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 路径
        **/
            private String path;

        /**
        * 路由
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
        * 菜单类型
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
        * 右节点
        **/
            private Integer rgt;

        /**
        * 最新修改时间
        **/
            private Date lastDate;
}