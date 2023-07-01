package com.nbsaas.life.system.data.entity;

import com.nbsaas.boot.code.annotation.CatalogClass;
import com.nbsaas.boot.code.annotation.FieldConvert;
import com.nbsaas.boot.jpa.data.entity.CatalogEntity;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 菜单实体
 *
 * @author ada
 */

@CatalogClass
@Data
@Entity
@Table(name = "sys_menu")
public class Menu extends CatalogEntity {

    /**
     * 分类 0为菜单1为功能
     */
    @Comment( "菜单类型")
    private Integer catalog;
    /**
     * 子菜单
     */
    @OrderBy("sortNum asc")
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private List<Menu> children;
    /**
     * 图标
     */
    private String icon;
    /**
     * 子节点数量
     */
    private Long nums;
    /**
     * 父分类
     */

    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private Menu parent;

    /**
     * url地址
     */
    private String path;

    /**
     * 该功能的权限
     */
    private String permission;

    /**
     * 路由
     */
    private String router;

    @Comment("是否租户使用")
    private Integer menuType;

    @Override
    public Serializable getParentId() {
        if (parent != null) {
            return parent.getId();
        }
        return null;
    }
}
