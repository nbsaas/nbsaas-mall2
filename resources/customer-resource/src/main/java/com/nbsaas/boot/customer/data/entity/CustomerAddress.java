package com.nbsaas.boot.customer.data.entity;

import com.nbsaas.boot.area.data.entity.Area;
import com.nbsaas.boot.code.annotation.*;
import com.nbsaas.boot.jpa.data.entity.LongEntity;
import com.nbsaas.boot.rest.enums.StoreState;
import com.nbsaas.boot.rest.filter.Operator;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.Date;

@org.hibernate.annotations.Table(appliesTo = "bs_customer_address", comment = "收货地址")
@EqualsAndHashCode
@Data
@FormAnnotation(model = "收货地址")
@Entity
@Table(name = "bs_customer_address")
public class CustomerAddress extends LongEntity {

    @Comment("收货人姓名")
    @FormField(title = "收货人姓名", sortNum = "1", grid = true, col = 12)
    @Column(length = 30)
    private String name;

    @Comment("手机号码")
    @FormField(title = "手机号码", sortNum = "1", grid = true, col = 12)
    @Column(length = 50)
    private String phone;

    @Comment("座机号码")
    @FormField(title = "座机", sortNum = "1", grid = true, col = 12)
    @Column(length = 20)
    private String tel;

    @Comment("详细地址")
    @FormField(title = "详细地址", sortNum = "1", grid = true, col = 12)
    @Column(length = 50)
    private String address;

    @Comment("门牌号")
    @FormField(title = "门牌号", sortNum = "1", grid = true, col = 12)
    @Column(length = 20)
    private String houseNo;

    @Comment("标签")
    @FormField(title = "标签", sortNum = "1", grid = true, col = 12)
    @Column(length = 20)
    private String label;

    @Comment("纬度")
    private Double lat;

    @Comment("经度")
    private Double lng;

    @JoinColumn(name = "province_id")
    @Comment("省份id")
    @SearchItem(label = "省份", name = "province", key = "province.id", classType = Long.class, operator = Operator.eq, show = false)
    @FormField(title = "省份", grid = true, ignore = true, sort = true)
    @FieldName
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private Area province;

    @JoinColumn(name = "city_id")
    @Comment("城市id")
    @SearchItem(label = "城市", name = "city", key = "city.id", classType = Long.class, operator = Operator.eq, show = false)
    @FormField(title = "城市", grid = true, ignore = true, sort = true)
    @FieldName
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private Area city;

    @JoinColumn(name = "area_id")
    @Comment("区县id")
    @SearchItem(label = "区县", name = "area", key = "area.id", classType = Long.class, operator = Operator.eq, show = false)
    @FormField(title = "区县", grid = true, ignore = true, type = InputType.select, sort = true)
    @FieldName
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private Area area;

    @Comment("邮编")
    @FormField(title = "邮编", sortNum = "1", grid = true, col = 12)
    @Column(length = 20)
    private String postalCode;

    @Comment("备注")
    @FormField(title = "备注", sortNum = "1", grid = true, col = 12)
    private String note;

    @JoinColumn(name = "customer_id")
    @Comment("用户id")
    @SearchItem(label = "用户", name = "customer", key = "customer.id", classType = Long.class, operator = Operator.eq, show = false)
    @FieldName
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @Comment("存储状态")
    private StoreState storeState;


    @FormField(title = "添加时间", grid = true, width = "11111", ignore = true)
    @Comment("添加时间")
    private Date addDate;

    @Comment("最新修改时间")
    private Date lastDate;
}
