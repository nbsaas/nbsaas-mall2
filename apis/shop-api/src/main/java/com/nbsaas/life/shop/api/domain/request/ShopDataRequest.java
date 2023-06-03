package com.nbsaas.life.shop.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;

/**
 * 请求对象
 */
@Data
public class ShopDataRequest implements Serializable, RequestId {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     * 最新修改时间
     **/
        private Date lastDate;

    /**
     * 地址
     **/
        private String address;

    /**
     * 经度
     **/
        private Double longitude;

    /**
     * 总体评分
     **/
        private Float overallRating;

    /**
     * 城市id
     **/
        private Long city;

    /**
     * 照片数量
     **/
        private Integer photos;

    /**
     * 服务评分
     **/
        private Float serviceRating;

    /**
     * 口味评分
     **/
        private Float tasteRating;

    /**
     * 纬度
     **/
        private Double latitude;

    /**
     * 图片
     **/
        private String image;

    /**
     * 优惠数量
     **/
        private Integer discountNum;

    /**
     * 营业时间
     **/
        private String shopHours;

    /**
     * 主键id
     **/
        private Long id;

    /**
     * 省份id
     **/
        private Long province;

    /**
     * 电话
     **/
        private String phone;

    /**
     * 签到数量
     **/
        private Integer checkinNum;

    /**
     * POI商户的价格
     **/
        private Float price;

    /**
     * 团购数量
     **/
        private Integer grouponNum;

    /**
     * 技术评分
     **/
        private Float technologyRating;

    /**
     * 图片数量
     **/
        private Float imageNum;

    /**
     * 网址
     **/
        private String website;

    /**
     * 距离中心点的距离
     **/
        private Integer distance;

    /**
     * 设备评分
     **/
        private Float facilityRating;

    /**
     * 状态
     **/
        private Integer state;

    /**
     * POI详情页
     **/
        private String detailUrl;

    /**
     * 收藏数量
     **/
        private Integer favoriteNum;

    /**
     * POI唯一标识
     **/
        private String poi;

    /**
     * 用户
     **/
        private Long user;

    /**
     * 添加时间
     **/
        private Date addDate;

    /**
     * 卫生评分
     **/
        private Float hygieneRating;

    /**
     * 商店名称
     **/
        private String name;

    /**
     * 区县id
     **/
        private Long area;

    /**
     * 评论数量
     **/
        private Integer commentNum;

    /**
     * 环境评分
     **/
        private Float environmentRating;
}