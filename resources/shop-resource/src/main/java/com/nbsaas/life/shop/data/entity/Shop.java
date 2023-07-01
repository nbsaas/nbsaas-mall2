package com.nbsaas.life.shop.data.entity;


import com.nbsaas.boot.code.annotation.FieldConvert;
import com.nbsaas.boot.code.annotation.FormAnnotation;
import com.nbsaas.boot.code.annotation.FormField;
import com.nbsaas.boot.code.annotation.SearchItem;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.rest.filter.Search;
import com.nbsaas.life.area.data.entity.Area;
import com.nbsaas.life.user.data.entity.UserInfo;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.*;


@org.hibernate.annotations.Table(appliesTo = "shop", comment = "店铺")
@Data
@FormAnnotation(title = "商店", model = "商店")
@Entity
@Table(name = "shop")
public class Shop extends AbstractEntity {


    @SearchItem(label = "商店名称",name = "name",key = "name")
    @FormField(title = "商店名称", sortNum = "1", grid = true)
    @Column(length = 100)
    @Comment("商店名称")
    private String name;

    @FormField(title = "地址", sortNum = "2", grid = true)
    @Column(length = 100)
    @Comment("地址")
    private String address;

    @Comment("营业时间")
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "shop_time")
    @MapKeyColumn(name = "week_index", length = 100)
    @OrderBy("week asc")
    private Map<Integer, ShopTime> times = new HashMap<>();

    @Comment("商家所有分类")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "shop_category_links")
    private Set<ShopCategory> categories = new HashSet<>();

    @Comment("POI唯一标识")
    @Column(length = 100)
    private String poi;

    @Comment("图片")
    @Column(length = 300)
    private String image;

    @FormField(title = "电话", sortNum = "3", grid = true)
    @Column(length = 100)
    @Comment("电话")
    private String phone;

    @FormField(title = "网址", sortNum = "4", grid = true)
    @Column(length = 100)
    @Comment("网址")
    private String website;

    @Comment("经度")
    private Double longitude;

    @Comment("纬度")
    private Double latitude;

    @Comment("距离中心点的距离")
    private Integer distance;

    @Comment("照片数量")
    private Integer photos;

    @FormField(title = "状态", sortNum = "5", grid = true)
    @Comment("状态")
    private Integer state;

    @Comment("POI详情页")
    private String detailUrl;

    @Comment("POI商户的价格")
    private Float price;

    @Comment("营业时间")
    private String shopHours;

    @Comment("总体评分")
    private Float overallRating;

    @Comment("口味评分")
    private Float tasteRating;

    @Comment("服务评分")
    private Float serviceRating;

    @Comment("环境评分")
    private Float environmentRating;

    @Comment("设备评分")
    private Float facilityRating;

    @Comment("卫生评分")
    private Float hygieneRating;

    @Comment("技术评分")
    private Float technologyRating;

    @Comment("图片数量")
    private Float imageNum;

    @Comment("团购数量")
    private Integer grouponNum;

    @Comment("优惠数量")
    private Integer discountNum;

    @Comment("评论数量")
    private Integer commentNum;

    @Comment("收藏数量")
    private Integer favoriteNum;

    @FormField(title = "签到数量", sortNum = "6", grid = true)
    @Comment("签到数量")
    private Integer checkinNum;

    @Comment("商店标签")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "shop_tag_links")
    private Set<ShopTag> tags = new HashSet<>();

    @FieldConvert
    @Comment("用户")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserInfo user;

    @FieldConvert
    @Comment("省份id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Area province;


    @FieldConvert
    @Comment("城市id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Area city;


    @FieldConvert
    @Comment("区县id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Area area;


    public ShopTime getCurDay() {
        Calendar calendar = Calendar.getInstance();
        int curweek = calendar.get(Calendar.DAY_OF_WEEK);
        curweek = curweek - 2;
        if (curweek == -1) {
            curweek = 6;
        }
        //1周天 6
        //2 周一0
        //7 周六-5
        //        weeks.put(0, "周一");
        //		weeks.put(1, "周二");
        //weeks.put(2, "周三");
        //weeks.put(3, "周四");
        //.put(4, "周五");
        //weeks.put(5, "周六");
        //weeks.put(6, "周日");

        return times.get(curweek);
    }

    public List<ShopTime> getDays() {
        List<ShopTime> days = new ArrayList<ShopTime>();
        if (times != null && times.values() != null && times.values().size() > 0) {
            days.addAll(times.values());
        }
        return days;
    }


}
