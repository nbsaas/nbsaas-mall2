package com.nbsaas.boot.order.data.entity;


import com.nbsaas.boot.code.annotation.*;
import com.nbsaas.boot.jpa.data.entity.LongEntity;
import com.nbsaas.boot.rest.filter.Operator;
import com.nbsaas.boot.shop.data.entity.Shop;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@org.hibernate.annotations.Table(appliesTo = "bs_order_hotel_item", comment = "酒店订单")
@Data
@FormAnnotation(title = "酒店订单", showHandle = false)
@Entity
@Table(name = "bs_order_hotel_item")
public class OrderHotelItem extends LongEntity {

    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;



    @FormField(title = "商家", grid = true,type = InputType.select,option = "shop",col = 22,ignore = true)
    @SearchItem(label = "商家", name = "shop", key = "shop.id", operator = Operator.eq, classType = Long.class,type = InputType.select)
    @Comment("商家id")
    @JoinColumn(name = "shop_id")
    @FieldConvert
    @FieldName
    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;


    @FormField(title = "价格", grid = true, col = 12, required = true)
    private BigDecimal price;

    @FormField(title = "入住人姓名", grid = true, col = 12)
    private String name;

    @FormField(title = "入住人电话", grid = true, col = 12)
    private String phone;

    @FormField(title = "入住开始时间", grid = true, col = 12, type = InputType.date,required = true)
    private Date beginTime;

    @FormField(title = "入住结束时间", grid = true, col = 12, type = InputType.date)
    private Date endTime;

    @FormField(title = "备注", col = 24, type = InputType.textarea)
    private String note;

}
