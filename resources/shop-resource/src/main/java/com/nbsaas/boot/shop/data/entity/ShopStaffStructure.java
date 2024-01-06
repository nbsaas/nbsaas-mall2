package com.nbsaas.boot.shop.data.entity;

import com.nbsaas.boot.code.annotation.*;
import com.nbsaas.boot.jpa.data.entity.CatalogEntity;
import com.nbsaas.boot.rest.filter.Operator;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@CatalogClass
@Data
@FormAnnotation(title = "商家部门",model = "商家部门")
@Entity
@Table(name = "bs_shop_staff_structure")
public class ShopStaffStructure extends CatalogEntity {

    @SearchItem(label = "商家", name = "shop", key = "shop.id", operator = Operator.eq, classType = Long.class)
    @Comment("商家id")
    @JoinColumn(name = "shop_id")
    @FieldConvert
    @FieldName
    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;

    @Comment("商家部门父id")
    @JoinColumn(name = "parent_id")
    @FieldConvert
    @FieldName
    @ManyToOne(fetch = FetchType.LAZY)
    private ShopStaffStructure parent;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "parent")
    private List<ShopStaffStructure> children;

    @Override
    public Serializable getParentId() {
        if (parent != null) {
            return parent.getId();
        }
        return null;
    }
}
