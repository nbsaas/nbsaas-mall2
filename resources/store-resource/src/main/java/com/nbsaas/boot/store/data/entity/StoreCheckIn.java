package com.nbsaas.boot.store.data.entity;

import com.nbsaas.boot.code.annotation.*;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.rest.filter.Operator;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;


@CreateByUser
@ComposeView
@Data
@FormAnnotation(title = "场馆入场管理", model = "场馆入场")
@Entity
@Table(name = "bs_store_check_in")
public class StoreCheckIn extends AbstractEntity {


    @FormField(title = "场馆",grid = true, col = 12,width = "200",required = true,type = InputType.select,option = "store")
    @SearchItem(label = "场馆", name = "store", key = "store.id", classType = Long.class, operator = Operator.eq)
    @FieldName
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;


//    @FieldConvert
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Staff creator;
//
//    @Comment("入场类型 人脸或者扫码")
//    private CheckInType checkInType;

    /**
     * 入场日期 例如 2021-9-25
     */
    @FormField(title = "入场日期",grid = true, col = 12,width = "200",required = true)
    @Column(length = 12)
    private String  day;


    @FormField(title = "当日入场次数",grid = true, col = 12,width = "200",required = true)
    private Integer amount;


    @FormField(title = "返款金额",grid = true, col = 12,width = "200",required = true)
    private BigDecimal backMoney;

}
