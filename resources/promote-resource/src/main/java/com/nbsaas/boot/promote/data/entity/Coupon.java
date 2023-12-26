package com.nbsaas.boot.promote.data.entity;

import com.nbsaas.boot.code.annotation.*;
import com.nbsaas.boot.customer.data.entity.Customer;
import com.nbsaas.boot.jpa.data.entity.LongEntity;
import com.nbsaas.boot.shop.data.entity.Shop;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;


@Data
@FormAnnotation(title = "优惠券",model = "优惠券",menu = "1,123,126")
@Entity
@Table(name = "bs_promote_coupon")
public class Coupon extends LongEntity {

    public static Coupon fromId(Long id) {
        Coupon result = new Coupon();
        result.setId(id);
        return result;
    }

    //优惠券类型(1 活动优惠券 2 普通优惠券 活动优惠券则费用由卖家承担，普通优惠券谁发行谁承担)
   // private CouponType couponType;

    private Short expireType;

    @FormField(title = "订单金额", sortNum = "5", grid = true, col = 12)
    private BigDecimal orderAmount;


    //使用条件-订单金额
    @FormField(title = "优惠卷金额", sortNum = "6", grid = true, col = 12)
    private BigDecimal discountAmount;

    @SearchItem(label = "名称", name = "name", key = "name")
    @FormField(title = "名称", sortNum = "1", grid = true, col = 12)
    private String name;

    @FormField(title = "优惠券开始时间", sortNum = "2", type = InputType.date, grid = true, col = 12)
    private Date useBeginTime;

    @FormField(title = "优惠券截止时间", sortNum = "3", type = InputType.date, grid = true, col = 12)
    private Date useEndTime;


    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;


    @FieldConvert
    @FieldName
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

}
