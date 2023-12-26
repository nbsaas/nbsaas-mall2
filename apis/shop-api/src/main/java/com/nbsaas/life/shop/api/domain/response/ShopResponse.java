package com.nbsaas.life.shop.api.domain.response;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
            import com.nbsaas.boot.rest.enums.StoreState;
/**
* 响应对象
*/
@Getter
@Setter
@ToString(callSuper = true)
public class ShopResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 优惠数量
        **/
            private Integer discountNum;

        /**
        * 距离中心点的距离
        **/
            private Integer distance;

        /**
        * 城市id
        **/
            private Long city;

        /**
        * 设备评分
        **/
            private Float facilityRating;

        /**
        * 纬度
        **/
            private Double latitude;

        /**
        * 团购数量
        **/
            private Integer grouponNum;

        /**
        * POI唯一标识
        **/
            private String poi;

        /**
        * 照片数量
        **/
            private Integer photos;

        /**
        * 环境评分
        **/
            private Float environmentRating;

        /**
        * 省份id
        **/
            private Long province;

        /**
        * POI商户的价格
        **/
            private Float price;

        /**
        * 状态
        **/
            private Integer state;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 经度
        **/
            private Double longitude;

        /**
        * 口味评分
        **/
            private Float tasteRating;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

        /**
        * 卫生评分
        **/
            private Float hygieneRating;

        /**
        * 区县id
        **/
            private Long area;

        /**
        * 图片
        **/
            private String image;

        /**
        * 网址
        **/
            private String website;

        /**
        * 地址
        **/
            private String address;

        /**
        * 总体评分
        **/
            private Float overallRating;

        /**
        * 图片数量
        **/
            private Float imageNum;

        /**
        * 服务评分
        **/
            private Float serviceRating;

        /**
        * 营业时间
        **/
            private String shopHours;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 收藏数量
        **/
            private Integer favoriteNum;

        /**
        * 评论数量
        **/
            private Integer commentNum;

        /**
        * 电话
        **/
            private String phone;

        /**
        * 商店名称
        **/
            private String name;

        /**
        * 
        **/
            //枚举
            private StoreState storeState;

            private String storeStateName;

        /**
        * POI详情页
        **/
            private String detailUrl;

        /**
        * 技术评分
        **/
            private Float technologyRating;

        /**
        * 签到数量
        **/
            private Integer checkinNum;

        /**
        * 用户
        **/
            private Long user;

}