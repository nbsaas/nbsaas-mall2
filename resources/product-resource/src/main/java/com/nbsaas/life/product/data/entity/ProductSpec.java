package com.nbsaas.life.product.data.entity;

import com.nbsaas.boot.code.annotation.FieldConvert;
import com.nbsaas.boot.code.annotation.FormAnnotation;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@FormAnnotation(title = "规格管理",model = "规格",menu = "1,107,109")
@Entity
@Table(name = "bs_product_spec")
public class ProductSpec extends AbstractEntity {

    @JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @Column(length = 20)
    private String name;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "productSpec",cascade = {CascadeType.REMOVE})
    private List<ProductSpecValue> values;
}
