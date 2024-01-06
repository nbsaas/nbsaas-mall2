package com.nbsaas.boot.shop.data.entity;


import com.nbsaas.boot.code.annotation.*;
import com.nbsaas.boot.code.annotation.data.Dict;
import com.nbsaas.boot.code.annotation.data.DictItem;
import com.nbsaas.boot.code.annotation.data.DictKey;
import com.nbsaas.boot.jpa.data.entity.LongEntity;
import com.nbsaas.boot.rest.filter.Operator;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.Date;

@Data
@FormAnnotation(title = "搜索词")
@Entity
@Table(name = "bs_shop_search_word")
public class ShopSearchWord extends LongEntity {



    @SearchItem(label = "商家", name = "shop", key = "shop.id", operator = Operator.eq, classType = Long.class)
    @Comment("商家id")
    @JoinColumn(name = "shop_id")
    @FieldConvert
    @FieldName
    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;


    @FormField(title = "搜索词", grid = true, col = 22)
    @Comment("搜索词")
    @Column(length = 50)
    private String word;

    @SearchItem(label = "消费者", name = "customer", key = "customer.id", operator = Operator.eq, classType = Long.class)
    @FormField(title = "添加入", grid = true, col = 22,ignore = true)
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private ShopStaff staff;


    @DictKey("searchType")
    @SearchItem(label = "搜索类型", name = "searchType", operator = Operator.eq, classType = Integer.class)
    @Dict(items = {
            @DictItem(value = 1, label = "商品"),
            @DictItem(value = 2, label = "文章")
    })
    @Comment("搜索类型")
    private Integer searchType;

    private Integer searchNum;


    @FormField(title = "排序号", grid = true, col = 22,type = InputType.el_input_number,sort = true)
    @Comment("排序号")
    private Integer sortNum;


    @FormField(title = "添加时间", grid = true, width = "11111", ignore = true)
    @Comment("添加时间")
    private Date addDate;

    @Comment("最新修改时间")
    private Date lastDate;
}
