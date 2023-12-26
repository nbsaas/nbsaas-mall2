package com.nbsaas.boot.product.data.entity;


import com.nbsaas.boot.code.annotation.FormAnnotation;
import com.nbsaas.boot.code.annotation.FormField;
import com.nbsaas.boot.code.annotation.InputType;
import com.nbsaas.boot.code.annotation.SearchItem;
import com.nbsaas.boot.code.annotation.bean.StoreStateBean;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.rest.enums.StoreState;
import com.nbsaas.boot.rest.filter.Operator;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@StoreStateBean
@Data
@FormAnnotation(title = "商品管理", model = "商品", menu = "1,164,165")
@Entity
@Table(name = "bs_product")
public class Product extends AbstractEntity {
    public static Product fromId(Long id) {
        Product result = new Product();
        result.setId(id);
        return result;
    }

    @FormField(title = "商品编码", sortNum = "1", grid = true, col = 12)
    private String barCode;

    private Long shop;

    @FormField(title = "商品主图", sortNum = "2", grid = false, col = 12)
    private String logo;

    @FormField(title = "商品缩略图", sortNum = "2", grid = false, col = 12)
    private String thumbnail;


    @SearchItem(label = "商品名称", name = "name")
    @FormField(title = "商品名称", sortNum = "2", grid = true, col = 12)
    private String name;

    @FormField(title = "商品简介", sortNum = "111", grid = false, col = 12, type = InputType.textarea)
    private String summary;

    @FormField(title = "库存", sortNum = "2", grid = true, col = 12)
    private Long stockNum;

    @FormField(title = "即时库存", sortNum = "2", grid = true, col = 12)
    private Long realStock;

    //更新库存日期
    private Date stockDate;

    @FormField(title = "价格", sortNum = "2", grid = true, col = 12, sort = true)
    private BigDecimal price;

    @FormField(title = "餐盒费", sortNum = "2", grid = true, col = 12)
    private BigDecimal mealFee;

    @FormField(title = "是否开启规格", sortNum = "2", col = 12)
    private Boolean skuEnable;


    @FormField(title = "折扣", sortNum = "2", col = 12)
    private BigDecimal discount;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<ProductSku> skus = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<ProductSpec> specs = new ArrayList<>();


    private BigDecimal minPrice;

    private BigDecimal maxPrice;

    @SearchItem(label = "storeState", name = "storeState",classType = StoreState.class,operator = Operator.eq)
    private StoreState storeState;
}
