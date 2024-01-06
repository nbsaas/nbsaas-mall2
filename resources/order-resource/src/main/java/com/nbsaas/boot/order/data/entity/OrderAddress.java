package com.nbsaas.boot.order.data.entity;


import com.nbsaas.boot.area.data.entity.Area;
import com.nbsaas.boot.code.annotation.*;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.rest.filter.Operator;
import lombok.Data;

import javax.persistence.*;

@org.hibernate.annotations.Table(appliesTo = "bs_order_address", comment = "订单地址")
@Data
@FormAnnotation(title = "订单")
@Entity
@Table(name = "bs_order_address")
public class OrderAddress extends AbstractEntity {

    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;



    @FormField(title = "座机", sortNum = "1", grid = true, col = 12)
    @Column(length = 20)
    private String tel;

    @FormField(title = "详细地址", sortNum = "1", grid = true, col = 12)
    @Column(length = 50)
    private String address;

    @FormField(title = "门牌号", sortNum = "1", grid = true, col = 12)
    @Column(length = 20)
    private String houseNo;

    @FormField(title = "标签", sortNum = "1", grid = true, col = 12)
    @Column(length = 20)
    private String label;

    private Double lat;

    private Double lng;


    @SearchItem(   label = "省份",    name = "province", key = "province.id",  classType =Long.class,  operator = Operator.eq, show = false  )
    @FormField(   title = "省份",    grid = true,   ignore = true,     sort = true  )
    @FieldName
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private Area province;

    @SearchItem( label = "城市",     name = "city",  key = "city.id",   classType = Long.class,  operator = Operator.eq,   show = false  )
    @FormField(  title = "城市",   grid = true,   ignore = true,   sort = true  )
    @FieldName
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private Area city;


    @SearchItem(label = "区县",   name = "area", key = "area.id", classType = Long.class,operator = Operator.eq, show = false )
    @FormField( title = "区县",  grid = true, ignore = true,  type = InputType.select, sort = true )
    @FieldName
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private Area area;

    @FormField(title = "邮编", sortNum = "1", grid = true, col = 12)
    @Column(length = 20)
    private String postalCode;

    @FormField(title = "备注", sortNum = "1", grid = true, col = 12)
    private String note;

    @SearchItem(label = "收货人",name = "consignee")
    @Column(length = 20)
    @FormField(title = "收货人", sortNum = "1", grid = true, col = 12)
    private String consignee;

    @SearchItem(label = "联系电话",name = "phone")
    @Column(length = 20)
    @FormField(title = "联系电话", sortNum = "1", grid = true, col = 12)
    private String phone;

}
