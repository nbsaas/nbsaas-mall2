package com.nbsaas.life.shop.data.entity;

import com.nbsaas.boot.code.annotation.FieldConvert;
import com.nbsaas.boot.code.annotation.FieldName;
import com.nbsaas.boot.code.annotation.FormAnnotation;
import com.nbsaas.boot.code.annotation.SearchItem;
import com.nbsaas.boot.jpa.data.entity.LongEntity;
import com.nbsaas.boot.rest.filter.Operator;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.Date;

@Data
@FormAnnotation(title = "商家部门")
@Entity
@Table(name = "bs_shop_config")
public class ShopConfig extends LongEntity {

    @SearchItem(label = "商家", name = "shop", key = "shop.id", operator = Operator.eq, classType = Long.class)
    @Comment("商家id")
    @JoinColumn(name = "shop_id")
    @FieldConvert
    @FieldName
    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;

    @Comment("配置类标识")
    @Column(unique = true)
    private String className;


    @Comment("配置json数据")
    private String configData;

    @Comment("添加时间")
    private Date addDate;

    @Comment("最新修改时间")
    private Date lastDate;
}
