package com.nbsaas.boot.product.data.entity;

import com.nbsaas.boot.code.annotation.FormAnnotation;
import com.nbsaas.boot.code.annotation.FormField;
import com.nbsaas.boot.code.annotation.InputType;
import com.nbsaas.boot.code.annotation.SearchItem;
import com.nbsaas.boot.code.annotation.bean.StoreStateBean;
import com.nbsaas.boot.code.annotation.data.Dict;
import com.nbsaas.boot.code.annotation.data.DictItem;
import com.nbsaas.boot.jpa.data.entity.LongEntity;
import com.nbsaas.boot.rest.enums.StoreState;
import com.nbsaas.boot.rest.filter.Operator;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@StoreStateBean
@Data
@FormAnnotation(title = "品牌", model = "品牌")
@Entity
@Table(name = "bs_brand")
@org.hibernate.annotations.Table(appliesTo = "bs_brand", comment = "品牌")
public class Brand extends LongEntity {

    @Comment("储存状态")
    @SearchItem(label = "storeState", name = "storeState", classType = StoreState.class, operator = Operator.eq)
    private StoreState storeState;

    @FormField(title = "品牌名称", grid = true, col = 22)
    @Comment("品牌名称")
    private String name;

    @FormField(title = "品牌logo", type = InputType.image, col = 22)
    @Comment("品牌logo")
    private String logo;

    @FormField(title = "品牌介绍", type = InputType.textarea, col = 22)
    @Comment("品牌介绍")
    private String note;

    @Dict(items = {
            @DictItem(value = 1, label = "是"),
            @DictItem(value = 2, label = "否")
    })
    @FormField(title = "是否推荐", type = InputType.dictionary, col = 22)
    @Comment("是否推荐")
    private Integer recommend;

    @FormField(title = "添加时间", grid = true, width = "11111", ignore = true)
    @Comment("添加时间")
    private Date addDate;


    @Comment("最新修改时间")
    private Date lastDate;
}
