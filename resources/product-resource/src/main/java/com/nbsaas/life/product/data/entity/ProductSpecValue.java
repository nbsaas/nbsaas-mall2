package com.nbsaas.life.product.data.entity;

import com.nbsaas.boot.code.annotation.FieldConvert;
import com.nbsaas.boot.code.annotation.FieldName;
import com.nbsaas.boot.code.annotation.FormAnnotation;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.*;


@Data
@FormAnnotation(title = "规格管理",model = "规格",menu = "1,107,109")
@Entity
@Table(name = "bs_product_spec_value")
public class ProductSpecValue extends AbstractEntity {

    @Column(length = 20)
    private String name;

    @JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @FieldConvert
    @FieldName
    @ManyToOne(fetch = FetchType.LAZY)
    private ProductSpec productSpec;
}
