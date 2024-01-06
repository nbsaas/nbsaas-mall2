package com.nbsaas.boot.shop.data.entity;


import com.nbsaas.boot.code.annotation.*;
import com.nbsaas.boot.jpa.data.entity.LongEntity;
import com.nbsaas.boot.rest.filter.Operator;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.Date;

@Data
@FormAnnotation(title = "热词")
@Entity
@Table(name = "bs_shop_hot_word")
public class ShopHotWord extends LongEntity {



    @SearchItem(label = "商家", name = "shop", key = "shop.id", operator = Operator.eq, classType = Long.class,show = false)
    @Comment("商家id")
    @JoinColumn(name = "shop_id")
    @FieldConvert
    @FieldName
    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;

    @SearchItem(label = "热词", name = "word")
    @FormField(title = "热词", grid = true, col = 22)
    @Comment("热词")
    @Column(length = 50)
    private String word;

    @FormField(title = "添加入", grid = true, col = 22,ignore = true)
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private ShopStaff staff;


    @FormField(title = "排序号", grid = true, col = 22,type = InputType.el_input_number,sort = true)
    @Comment("排序号")
    private Integer sortNum;

    @FormField(title = "添加时间", grid = true, width = "11111", ignore = true)
    @Comment("添加时间")
    private Date addDate;

    @Comment("最新修改时间")
    private Date lastDate;
}
