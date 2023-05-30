package com.nbsaas.life.shop.api.domain.request;

import com.nbsaas.boot.rest.filter.Operator;
import com.nbsaas.boot.rest.filter.Search;
import com.nbsaas.boot.rest.request.PageRequest;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
* 搜索bean
*/
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ShopSearchRequest extends PageRequest implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;

    /**
     * 地址
     **/
    @Search(name = "address", operator = Operator.like)
    private String address;
    /**
     * 照片数量
     **/
    @Search(name = "photos", operator = Operator.eq)
    private Integer photos;
    /**
     * 图片
     **/
    @Search(name = "image", operator = Operator.like)
    private String image;
    /**
     * 优惠数量
     **/
    @Search(name = "discountNum", operator = Operator.eq)
    private Integer discountNum;
    /**
     * 营业时间
     **/
    @Search(name = "shopHours", operator = Operator.like)
    private String shopHours;
    /**
     * 主键id
     **/
    @Search(name = "id", operator = Operator.eq)
    private Long id;
    /**
     * 电话
     **/
    @Search(name = "phone", operator = Operator.like)
    private String phone;
    /**
     * 签到数量
     **/
    @Search(name = "checkinNum", operator = Operator.eq)
    private Integer checkinNum;
    /**
     * 团购数量
     **/
    @Search(name = "grouponNum", operator = Operator.eq)
    private Integer grouponNum;
    /**
     * 网址
     **/
    @Search(name = "website", operator = Operator.like)
    private String website;
    /**
     * 距离中心点的距离
     **/
    @Search(name = "distance", operator = Operator.eq)
    private Integer distance;
    /**
     * 状态
     **/
    @Search(name = "state", operator = Operator.eq)
    private Integer state;
    /**
     * POI详情页
     **/
    @Search(name = "detailUrl", operator = Operator.like)
    private String detailUrl;
    /**
     * 收藏数量
     **/
    @Search(name = "favoriteNum", operator = Operator.eq)
    private Integer favoriteNum;
    /**
     * POI唯一标识
     **/
    @Search(name = "poi", operator = Operator.like)
    private String poi;
    /**
     * 商店名称
     **/
    @Search(name = "name", operator = Operator.like)
    private String name;
    /**
     * 评论数量
     **/
    @Search(name = "commentNum", operator = Operator.eq)
    private Integer commentNum;


}