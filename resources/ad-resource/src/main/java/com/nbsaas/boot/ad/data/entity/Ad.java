package com.nbsaas.boot.ad.data.entity;

import com.nbsaas.boot.code.annotation.*;
import com.nbsaas.boot.jpa.data.entity.SortEntity;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.Date;

@org.hibernate.annotations.Table(appliesTo = "bs_basic_ad", comment = "广告")
@FormAnnotation(title = "广告管理", model = "广告")
@Data
@Entity
@Table(name = "bs_basic_ad")
public class Ad extends SortEntity {

    /**
     * 标题
     */
    @Comment("广告名称")
    @SearchItem(label = "广告名称",name = "title")
    @FormField(title = "广告名称", sortNum = "10", grid = true, col = 22, required = true)
    private String title;

    /**
     * 广告位
     */
    @Comment("广告位")
    //@SearchItem(label = "广告位", name = "adPosition", key = "adPosition.id", sortNum = "-1", type = InputType.select, classType = "Long", operator = "eq")
    @FormField(title = "广告位", sortNum = "10", grid = true, col = 22, type = InputType.select, option = "adPosition", required = true)
    @FieldName
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn()
    private AdPosition adPosition;

//    /**
//     * 类型
//     */
//    private AdType type;

    /**
     * 路径
     */
    @Comment("广告图片")
    @FormField(title = "广告图片", sortNum = "20", grid = true, col = 22, type = InputType.image)
    private String path;

    /**
     * 起始日期
     */
    @Comment("广告开始时间")
    @FormField(title = "广告开始时间", sortNum = "20",  col = 22, type = InputType.el_date_time_picker)
    private Date beginDate;

    /**
     * 结束日期
     */
    @Comment("广告结束时间")
    @FormField(title = "广告结束时间", sortNum = "30", grid = true, col = 22, type = InputType.el_date_time_picker,width = "160")
    private Date endDate;

    /**
     * 链接地址
     */
    @Comment("链接地址")
    @FormField(title = "链接地址", sortNum = "40", grid = true, col = 22)
    private String url;


    /**
     * 分类
     */
    @Comment("分类")
    private Integer catalog;


    @Comment("内容")
    @FormField(title = "内容", sortNum = "60", grid = true, col = 22, type = InputType.textarea,width = "10000")
    private String note;

    @Comment("业务id")
    private Long bussId;

}