package com.nbsaas.boot.store.data.entity;

import com.nbsaas.boot.code.annotation.*;
import com.nbsaas.boot.customer.data.entity.Customer;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.rest.filter.Operator;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;


@SearchBean(items = {
        @SearchItem(label = "会员名称", name = "staffName", key = "staff.name",  operator = Operator.like),
        @SearchItem(label = "会员电话", name = "staffPhone", key = "staff.phone",  operator = Operator.like),
        @SearchItem(label = "商家名称", name = "storeName", key = "store.name",  operator = Operator.like)

})
@org.hibernate.annotations.Table(appliesTo = "bs_store_pay", comment = "付款记录")
@Data
@FormAnnotation(title = "付款记录")
@Entity
@Table(name = "bs_store_pay")
public class StorePay extends AbstractEntity {


    @FormField(title = "会员名称", grid = true, col = 12, width = "110")
    @FieldName
    @SearchItem(label = "会员名称", name = "customer", key = "customer.id", classType = Long.class, operator = Operator.eq, show = false)
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;


    @FormField(title = "商家名称", grid = true, col = 12, width = "200", required = true, type = InputType.select, option = "store")
    @SearchItem(label = "商家名称", name = "store", key = "store.id", classType = Long.class, operator = Operator.eq, show = false, type = InputType.select)
    @FieldName
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;

    @FormField(title = "原价", grid = true, col = 12, required = true)
    private BigDecimal originalPrice;

    @FormField(title = "神券抵扣", grid = true, col = 12, required = true)
    private BigDecimal deduction;

    @FormField(title = "实付金额", grid = true, col = 12, required = true)
    private BigDecimal payMoney;

    @FormField(title = "商家返款", grid = true, col = 12, required = true)
    private BigDecimal backMoney;

}
