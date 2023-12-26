package com.nbsaas.life.shop.data.entity;

import com.nbsaas.boot.code.annotation.*;
import com.nbsaas.boot.jpa.data.entity.LongEntity;
import com.nbsaas.boot.rest.filter.Operator;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Data
@FormAnnotation(title = "商家部门")
@Entity
@Table(name = "bs_shop_role")
public class ShopRole extends LongEntity {

    @SearchItem(label = "商家", name = "shop", key = "shop.id", operator = Operator.eq, classType = Long.class)
    @Comment("商家id")
    @JoinColumn(name = "shop_id")
    @FieldConvert
    @FieldName
    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;

    @FormField(title = "名称", grid = true, col = 22)
    @Column(length = 20)
    private String name;


    @FormField(title = "角色介绍", grid = true, col = 22)
    @Column
    private String note;


}
