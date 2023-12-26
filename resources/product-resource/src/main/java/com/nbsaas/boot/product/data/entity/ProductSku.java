package com.nbsaas.boot.product.data.entity;


import com.nbsaas.boot.code.annotation.FieldConvert;
import com.nbsaas.boot.code.annotation.FormAnnotation;
import com.nbsaas.boot.code.annotation.FormField;
import com.nbsaas.boot.code.annotation.SearchItem;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Data
@FormAnnotation(title = "sku管理",model = "sku",menu = "1,107,109")
@Entity
@Table(name = "bs_product_sku")
public class ProductSku extends AbstractEntity {

    @JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @Column(length = 50)
    @SearchItem(label = "商品名称", name = "name")
    @FormField(title = "商品名称", sortNum = "2", grid = true, col = 12)
    private String name;

    //红色_64G_国行
    @FormField(title = "规格", sortNum = "2", grid = true, col = 12)
    private String spec;

    @FormField(title = "库存", sortNum = "2", grid = true, col = 12)
    private Long stockNum;

    @FormField(title = "价格", sortNum = "2", grid = true, col = 12)
    private BigDecimal price;

    @FormField(title = "餐盒费", sortNum = "2", grid = true, col = 12)
    private BigDecimal mealFee;


    @FormField(title = "折扣", sortNum = "2", col = 12)
    private Float discount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProductSku sku = (ProductSku) o;
        return Objects.equals(getId(), sku.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId());
    }
}
