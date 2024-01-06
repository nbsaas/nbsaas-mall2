package com.nbsaas.boot.store.data.entity;

import com.nbsaas.boot.code.annotation.*;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.rest.filter.Operator;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;


@org.hibernate.annotations.Table(appliesTo = "bs_store_image", comment = "商家图片")
@Data
@FormAnnotation(title = "商家图片", model = "商家图片", menu = "1,101,102")
@Entity
@Table(name = "bs_store_image")
public class StoreImage extends AbstractEntity {

    @Comment("图片地址")
    private String url;

    @Comment("场馆id")
    @JoinColumn(name = "store_id")
    @FormField(title = "场馆", grid = true, col = 12, width = "200", required = true, type = InputType.select, option = "store")
    @SearchItem(label = "场馆", name = "store", key = "store.id", classType = Long.class, operator = Operator.eq, show = false)
    @FieldName
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;

}
