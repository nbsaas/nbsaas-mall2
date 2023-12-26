package com.nbsaas.boot.product.data.entity;

import com.nbsaas.boot.code.annotation.*;
import com.nbsaas.boot.jpa.data.entity.CatalogEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@org.hibernate.annotations.Table(appliesTo = "bs_product_catalog",comment = "商品分类")
@Data
@FormAnnotation(title = "商品分类", model = "商品分类")
@Entity
@Table(name = "bs_product_catalog")
@CatalogClass
public class ProductCatalog extends CatalogEntity {

    @FieldConvert
    @FieldName
    @ManyToOne(fetch = FetchType.LAZY)
    private ProductCatalog parent;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "parent")
    private List<ProductCatalog> children;

    @Override
    public Serializable getParentId() {
        if (parent!=null){
            return parent.getId();
        }
        return null;
    }
}
