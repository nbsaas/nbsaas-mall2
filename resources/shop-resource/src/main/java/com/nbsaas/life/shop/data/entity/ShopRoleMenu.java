package com.nbsaas.life.shop.data.entity;

import com.nbsaas.boot.app.data.entity.AppMenu;
import com.nbsaas.boot.code.annotation.*;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.rest.filter.Operator;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@BeanExt(items = {
        @FormExtField(fieldName = "permission", parentField = "permission", parent = "menu", fieldClass = String.class)
})
@org.hibernate.annotations.Table(appliesTo = "bs_shop_role_menu", comment = "角色功能表")
@Data
@Entity
@Table(name = "bs_shop_role_menu")
public class ShopRoleMenu extends AbstractEntity {


    @FieldConvert
    @Comment("角色id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ShopRole role;


    @FieldConvert
    @Comment("菜单id")
    @ManyToOne(fetch = FetchType.LAZY)
    private AppMenu menu;

    @SearchItem(label = "商家", name = "shop", key = "shop.id", operator = Operator.eq, classType = Long.class)
    @Comment("商家id")
    @JoinColumn(name = "shop_id")
    @FieldConvert
    @FieldName
    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;

}