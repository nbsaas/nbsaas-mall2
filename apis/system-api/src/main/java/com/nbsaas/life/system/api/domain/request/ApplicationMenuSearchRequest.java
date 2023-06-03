package com.nbsaas.life.system.api.domain.request;

import com.nbsaas.boot.rest.filter.Operator;
import com.nbsaas.boot.rest.filter.Search;
import com.nbsaas.boot.rest.request.PageRequest;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 搜索bean
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ApplicationMenuSearchRequest extends PageRequest implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     * 编码
     **/
    @Search(name = "code", operator = Operator.like)
    private String code;

    /**
     * 左节点
     **/
    @Search(name = "lft", operator = Operator.eq)
    private Integer lft;

    /**
     * 深度
     **/
    @Search(name = "depth", operator = Operator.eq)
    private Integer depth;

    /**
     * 路由
     **/
    @Search(name = "router", operator = Operator.like)
    private String router;

    /**
     * 分类
     **/
    @Search(name = "catalog", operator = Operator.eq)
    private Integer catalog;

    /**
     *
     **/
    @Search(name = "num", operator = Operator.eq)
    private Long num;

    /**
     * 图标
     **/
    @Search(name = "icon", operator = Operator.like)
    private String icon;

    /**
     * 排序号
     **/
    @Search(name = "sortNum", operator = Operator.eq)
    private Integer sortNum;

    /**
     * 主键id
     **/
    @Search(name = "id", operator = Operator.eq)
    private Long id;

    /**
     * 菜单类型
     **/
    @Search(name = "menuType", operator = Operator.eq)
    private Integer menuType;

    /**
     * 右节点
     **/
    @Search(name = "rgt", operator = Operator.eq)
    private Integer rgt;

    /**
     * 创建人id
     **/
    @Search(name = "creator", operator = Operator.eq)
    private Long creator;

    /**
     * 名称
     **/
    @Search(name = "name", operator = Operator.like)
    private String name;

    /**
     * 权限
     **/
    @Search(name = "permission", operator = Operator.like)
    private String permission;

    /**
     * 路径
     **/
    @Search(name = "path", operator = Operator.like)
    private String path;

    /**
     * ids
     **/
    @Search(name = "ids", operator = Operator.like)
    private String ids;

    private int fetch;

    @Search(name = "levelInfo", operator = Operator.eq)
    private Integer level;

}