package com.nbsaas.boot.shop.data.entity;

import com.nbsaas.boot.code.annotation.FieldConvert;
import com.nbsaas.boot.code.annotation.FieldName;
import com.nbsaas.boot.code.annotation.FormAnnotation;
import com.nbsaas.boot.code.annotation.SearchItem;
import com.nbsaas.boot.jpa.data.entity.LongEntity;
import com.nbsaas.boot.rest.filter.Operator;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Data
@FormAnnotation(title = "商家部门")
@Entity
@Table(name = "bs_shop_staff_role")
public class ShopStaffRole extends LongEntity {

    @SearchItem(label = "员工", name = "shopStaff",key = "shopStaff.id",operator = Operator.eq,classType = Long.class)
    @JoinColumn(name = "shop_staff_id")
    @Comment("店铺员工账号")
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private ShopStaff shopStaff;

    @SearchItem(label = "角色", name = "shopRole",key = "shopRole.id",operator = Operator.eq,classType = Long.class)
    @JoinColumn(name = "shop_role_id")
    @Comment("店铺用工角色")
    @FieldConvert
    @FieldName
    @ManyToOne(fetch = FetchType.LAZY)
    private ShopRole shopRole;

    @SearchItem(label = "商家", name = "shop", key = "shop.id", operator = Operator.eq, classType = Long.class)
    @Comment("商家id")
    @JoinColumn(name = "shop_id")
    @FieldConvert
    @FieldName
    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;

}
