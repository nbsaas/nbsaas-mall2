package com.nbsaas.boot.store.data.entity;


import com.nbsaas.boot.code.annotation.*;
import com.nbsaas.boot.customer.data.entity.Customer;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.rest.filter.Operator;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@SearchBean(items = {
        @SearchItem(label = "场馆", name = "storeName", key = "store.name"),
        @SearchItem(label = "会员名称", name = "customerName", key = "customer.name"),
        @SearchItem(label = "会员电话", name = "customerPhone", key = "customer.phone")
})
@BeanExt(items = {
        @FormExtField(title = "电话",grid = true, fieldName = "customerPhone", parentField = "phone", parent = "customer", fieldClass = String.class)
})
@ComposeView
@Data
@FormAnnotation(title = "场馆入场记录管理", model = "场馆入场记录", menu = "1,63,124")
@Entity
@Table(name = "bs_store_check_in_record")
public class StoreCheckInRecord extends AbstractEntity {

    @JoinColumn(name = "customer_id")
    @Comment("会员名称")
    @FormField(title = "会员名称", grid = true, col = 12, width = "110")
    @FieldName
    @SearchItem(label = "会员名称", name = "customer", key = "customer.id", classType = Long.class, operator = Operator.eq, show = false)
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @Comment("场馆id")
    @JoinColumn(name = "store_id")
    @FormField(title = "场馆", grid = true, col = 12, width = "200", required = true, type = InputType.select, option = "store")
    @SearchItem(label = "场馆", name = "store", key = "store.id", classType = Long.class, operator = Operator.eq, show = false)
    @FieldName
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;



//    @FormField(title = "入场类型", grid = true, col = 12, width = "110")
//    @Comment("入场类型 人脸或者扫码")
//    private CheckInType checkInType;
}
