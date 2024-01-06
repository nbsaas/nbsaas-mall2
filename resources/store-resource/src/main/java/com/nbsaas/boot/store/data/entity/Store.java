package com.nbsaas.boot.store.data.entity;

import com.nbsaas.boot.code.annotation.*;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.rest.filter.Operator;
import com.nbsaas.boot.shop.data.entity.Shop;
import com.nbsaas.boot.trade.data.entity.TradeAccount;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@ComposeView
@org.hibernate.annotations.Table(appliesTo = "bs_store", comment = "商家")
@Data
@FormAnnotation(title = "商家")
@Entity
@Table(name = "bs_store")
public class Store extends AbstractEntity {

    public static Store fromId(Long id) {
        Store result = new Store();
        result.setId(id);
        return result;
    }

    @SearchItem(label = "商家", name = "shop", key = "shop.id", operator = Operator.eq, classType = Long.class,show = false)
    @Comment("商家id")
    @JoinColumn(name = "shop_id")
    @FieldConvert
    @FieldName
    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;

    /**
     * 场馆名称
     */
    @SearchItem(label = "商家名称", name = "name")
    @Comment("商家名称")
    @FormField(title = "商家名称", sortNum = "2", grid = true, col = 12,required = true,width = "200")
    private String name;

//    @Comment("商家类型")
//    @FormField(title = "商家类型", sortNum = "2", grid = true, col = 12)
//    private StoreType storeType;
//
//    @SearchItem(label = "状态", name = "shopState", classType = ShopState.class, operator = Operator.eq, show = false)
//    @FormField(title = "状态", grid = true, ignore = true)
//    private ShopState shopState;

    @SearchItem(label = "联系电话", name = "phone")
    @Comment("联系电话")
    @FormField(title = "联系电话", sortNum = "2", grid = true, col = 12,required = true,width = "120")
    private String phone;

    /**
     * 折扣
     */
    @Comment("返现折扣")
    @FormField(title = "返现折扣", sortNum = "2", grid = true, col = 12)
    private BigDecimal rebate;

    /**
     * 返款金额
     */
    @Comment("商家收入")
    @FormField(title = "商家收入", sortNum = "2", grid = true,ignore = true,sort = true)
    private BigDecimal income;




    /**
     * 场馆资金账户
     */
    @FormField(title = "商家余额", sortNum = "2", grid = true,ignore = true,width = "10000")
    @FieldName(parent = "amount",classType = "BigDecimal")
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private TradeAccount account;

    /**
     * 负责人
     */
    @Comment("负责人")
    @Column(length = 10)
    private String charge;


    /**
     * 负责人身份证号码
     */
    @Comment("负责人身份证号码")
    @Column(length = 20)
    private String chargeNo;




    /**
     * 银行名称
     */
    @Comment("银行名称")
    private String bankName;

    /**
     * 银行卡号
     */
    @Comment("银行卡号")
    private String bankNo;

    /**
     * 银行账号
     */
    @Comment("银行账号")
    private String bankAccount;

    /**
     * 活动摘要
     */
    @Comment("活动摘要")
    private String summary;

    /**
     * 人均消费
     */
    @Comment("人均消费")
    private BigDecimal money;

    /**
     * 返款金额
     */
    @Comment("返款金额")
    private BigDecimal backMoney;

    @Comment("门店logo")
    private String logo;

    @Comment("门店icon")
    private String icon;


    @FormField(title = "商家地址", sortNum = "2", col = 24 )
    @Comment("商家地址")
    private String address;



    /**
     * 会员特权
     */
    @Comment("会员福利")
    @FormField(title = "会员福利", sortNum = "2", col = 24 ,type = InputType.textarea)
    private String privilege;


    @Comment("商家介绍")
    @FormField(title = "商家介绍", sortNum = "2", col = 24,type = InputType.textarea)
    private String note;

    /**
     * 提现比例
     */
    @Comment("提现比例")
    private Float rate;

    /**
     * 老板微信openid
     */
    private String openId;

    /**
     * 老板姓名
     */
    private String boss;




    @Comment("门店分类")
    @FieldConvert
    @FieldName
    @ManyToOne(fetch = FetchType.LAZY)
    private StoreCatalog storeCatalog;


    /**
     * 经度
     */
    @Comment("地理经度")
    private Double lng;

    /**
     * 地理纬度
     */

    @Comment("地理纬度")
    private Double lat;


    /**
     * 地图多少级可见
     */
    @Comment("地图多少级可见")
    private Integer zoom;


}
