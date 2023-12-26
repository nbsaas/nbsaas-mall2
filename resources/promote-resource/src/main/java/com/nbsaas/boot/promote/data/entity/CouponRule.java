package com.nbsaas.boot.promote.data.entity;

import com.nbsaas.boot.code.annotation.*;
import com.nbsaas.boot.jpa.data.entity.LongEntity;
import com.nbsaas.boot.rest.enums.StoreState;
import com.nbsaas.boot.rest.filter.Operator;
import com.nbsaas.boot.shop.data.entity.Shop;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;


@Data
@FormAnnotation(title = "优惠券", model = "优惠券")
@Entity
@Table(name = "bs_promote_coupon_rule")
public class CouponRule extends LongEntity {

    public static CouponRule fromId(Long id) {
        CouponRule result = new CouponRule();
        result.setId(id);
        return result;
    }

    @SearchItem(label = "名称", name = "name", key = "name")
    @FormField(title = "名称", grid = true, col = 20, required = true)
    private String name;

    @FormField(title = "封面", grid = true, col = 20, type = InputType.image)
    private String logo;

    @FormField(title = "面额", grid = true, col = 20)
    private BigDecimal money;

    @SearchItem(label = "商家", name = "shop", key = "shop", operator = Operator.eq, classType =Long.class, show = false)
    @FieldConvert
    @FieldName
    @FormField(title = "商家", grid = true, col = 20, type = InputType.select, option = "shop", required = true)
    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;

    @FormField(title = "使用门槛", type = InputType.money, grid = false, col = 20, sort = true)
    private BigDecimal minPrice;

    @FormField(title = "每人限领", type = InputType.el_input_number, grid = false, col = 20, sort = true)
    private Integer limitNum;

    @FormField(title = "发放开始时间", type = InputType.el_date_time_picker, grid = true, col = 20, sort = true)
    private Date sendBeginTime;

    @FormField(title = "发放截止时间", type = InputType.el_date_time_picker, grid = true, col = 20, sort = true)
    private Date sendEndTime;

//    @FormField(title = "有效期", type = InputType.el_radio_group, grid = false, col = 20)
//    private ExpireType expireType;

    @FormField(title = "优惠券开始时间", type = InputType.el_date_time_picker, grid = false, col = 20)
    private Date useBeginTime;

    @FormField(title = "优惠券截止时间", type = InputType.el_date_time_picker, grid = false, col = 20)
    private Date useEndTime;

    @FormField(title = "固定天数", grid = false, col = 20, type = InputType.el_input_number)
    private Integer useDay;


    /**
     * 活动范围(1全部商品 3部分类目)
     */
    @FormField(title = "活动范围", sortNum = "1", grid = false, col = 20)
    private Short couponScope;

    @FormField(title = "卡券库存", grid = false, col = 20, type = InputType.el_input_number)
    private Integer stock;

    private Long sendNum;

    private Long useNum;

    @FormField(title = "使用说明", grid = false, col = 20, type = InputType.textarea)
    private String note;


    //private CouponState couponState;


    private StoreState storeState;

    /**
     * 展示方式 平台，商店
     */
//    @SearchItem(label = "名称", name = "showType", classType = "ShowType", show = false)
//    private ShowType showType;
    /**
     * 优惠券类型
     */
//    @SearchItem(label = "优惠券类型", name = "couponCatalog", operator = "eq", show = false)
//    private CouponCatalog couponCatalog;

    /**
     * 结算比例
     */
    private Integer takeawayRate;

}
