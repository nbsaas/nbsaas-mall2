package com.nbsaas.boot.order.data.entity;

import com.nbsaas.boot.code.annotation.FormAnnotation;
import com.nbsaas.boot.code.annotation.FormField;
import com.nbsaas.boot.code.annotation.bean.StoreStateBean;
import com.nbsaas.boot.code.annotation.data.Dict;
import com.nbsaas.boot.code.annotation.data.DictItem;
import com.nbsaas.boot.jpa.data.entity.LongEntity;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@StoreStateBean
@Data
@FormAnnotation(title = "订单", model = "订单")
@Entity
@Table(name = "bs_order")
@org.hibernate.annotations.Table(appliesTo = "bs_order", comment = "订单")
public class Order extends LongEntity {



    @FormField(title = "添加时间", grid = true, width = "11111", ignore = true)
    @Comment("添加时间")
    private Date addDate;


    @Comment("最新修改时间")
    private Date lastDate;

    @Dict(items = {
            @DictItem(value = 1, label = "待支付"),
            @DictItem(value = 2, label = "待发货"),
            @DictItem(value = 3, label = "待收货"),
            @DictItem(value = 4, label = "待评价"),
            @DictItem(value = 5, label = "已完成"),
            @DictItem(value = 6, label = "已取消"),
    })
    @Comment("订单状态")
    private Integer state;

    @Dict(items = {
            @DictItem(value = 1, label = "微信"),
            @DictItem(value = 2, label = "支付宝"),
            @DictItem(value = 3, label = "银联"),
            @DictItem(value = 4, label = "快捷支付"),
            @DictItem(value = 5, label = "微信公众号"),
            @DictItem(value = 6, label = "微信小程序"),
        })
    @Comment("订单来源")
    private Integer sourceClient;


    @Dict(items = {
            @DictItem(value = 1, label = "普通订单"),
            @DictItem(value = 2, label = "团购订单"),
            @DictItem(value = 3, label = "秒杀订单")
    })
    @Comment("订单类型")
    private Integer catalog;
}
