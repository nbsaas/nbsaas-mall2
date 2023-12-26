package com.nbsaas.boot.shop.api.domain.request;

import com.nbsaas.boot.rest.filter.Operator;
import com.nbsaas.boot.rest.filter.Search;
import com.nbsaas.boot.rest.request.PageRequest;
import lombok.*;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import com.nbsaas.boot.rest.enums.StoreState;

/**
* 搜索bean
*/
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ShopSearch   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


    @Search(name = "name",operator = Operator.like)
    private String name;

    @Search(name = "storeState",operator = Operator.eq)
    private StoreState storeState;


            /**
            * 优惠数量
            **/
            @Search(name = "discountNum",operator = Operator.eq)
            private Integer discountNum;

            /**
            * 距离中心点的距离
            **/
            @Search(name = "distance",operator = Operator.eq)
            private Integer distance;

            /**
            * 团购数量
            **/
            @Search(name = "grouponNum",operator = Operator.eq)
            private Integer grouponNum;

            /**
            * POI唯一标识
            **/
            @Search(name = "poi",operator = Operator.like)
            private String poi;

            /**
            * 照片数量
            **/
            @Search(name = "photos",operator = Operator.eq)
            private Integer photos;

            /**
            * 状态
            **/
            @Search(name = "state",operator = Operator.eq)
            private Integer state;

            /**
            * 主键id
            **/
            @Search(name = "id",operator = Operator.eq)
            private Long id;

            /**
            * 图片
            **/
            @Search(name = "image",operator = Operator.like)
            private String image;

            /**
            * 网址
            **/
            @Search(name = "website",operator = Operator.like)
            private String website;

            /**
            * 地址
            **/
            @Search(name = "address",operator = Operator.like)
            private String address;

            /**
            * 营业时间
            **/
            @Search(name = "shopHours",operator = Operator.like)
            private String shopHours;

            /**
            * 收藏数量
            **/
            @Search(name = "favoriteNum",operator = Operator.eq)
            private Integer favoriteNum;

            /**
            * 评论数量
            **/
            @Search(name = "commentNum",operator = Operator.eq)
            private Integer commentNum;

            /**
            * 电话
            **/
            @Search(name = "phone",operator = Operator.like)
            private String phone;

            /**
            * POI详情页
            **/
            @Search(name = "detailUrl",operator = Operator.like)
            private String detailUrl;

            /**
            * 签到数量
            **/
            @Search(name = "checkinNum",operator = Operator.eq)
            private Integer checkinNum;



}