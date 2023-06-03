package com.nbsaas.life.system.api.domain.simple;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 列表对象
 */
@Data
public class ApplicationMenuSimple implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;

    private String value;
    private String label;
    private List
            <ApplicationMenuSimple> children;


    /**
     * 最新修改时间
     **/
    private Date lastDate;

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
     * 路由
     **/
    private String router;

    /**
     * 分类
     **/
    private Integer catalog;

    /**
     *
     **/
    private Long num;

    /**
     * 图标
     **/
    private String icon;

    /**
     * 应用
     **/
    private String appName;

    /**
     * 添加时间
     **/
    private Date addDate;

    /**
     * 排序号
     **/
    private Integer sortNum;

    /**
     * 应用
     **/
    private Long app;

    /**
     * 主键id
     **/
    private Long id;

    /**
     * 菜单类型
     **/
    private Integer menuType;

    /**
     * 右节点
     **/
    private Integer rgt;

    /**
     * 创建人id
     **/
    private Long creator;

    /**
     * 名称
     **/
    private String name;

    /**
     * 权限
     **/
    private String permission;

    /**
     * 路径
     **/
    private String path;

    /**
     * ids
     **/
    private String ids;


}