package com.nbsaas.boot.shop.api.domain.request;

import com.nbsaas.boot.rest.filter.Operator;
import com.nbsaas.boot.rest.filter.Search;
import com.nbsaas.boot.rest.request.PageRequest;
import lombok.*;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
* 搜索bean
*/
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ShopReviewSearch   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



            /**
            * 停车场
            **/
            @Search(name = "parking",operator = Operator.like)
            private String parking;

            /**
            * 衣著
            **/
            @Search(name = "attire",operator = Operator.like)
            private String attire;

            /**
            * 是否接受外带
            **/
            @Search(name = "takeout",operator = Operator.like)
            private String takeout;

            /**
            * 价格评分
            **/
            @Search(name = "priceScore",operator = Operator.eq)
            private Integer priceScore;

            /**
            * 是否提供户外座位
            **/
            @Search(name = "outdoorSeating",operator = Operator.like)
            private String outdoorSeating;

            /**
            * 是否接受信用卡
            **/
            @Search(name = "businessAcceptsCreditCards",operator = Operator.like)
            private String businessAcceptsCreditCards;

            /**
            * 服务评分
            **/
            @Search(name = "serviceScore",operator = Operator.eq)
            private Integer serviceScore;

            /**
            * 是否有单车停车位
            **/
            @Search(name = "bikeParking",operator = Operator.like)
            private String bikeParking;

            /**
            * 是否适合团体
            **/
            @Search(name = "goodForGroups",operator = Operator.like)
            private String goodForGroups;

            /**
            * 主键id
            **/
            @Search(name = "id",operator = Operator.eq)
            private Long id;

            /**
            * 是否适合儿童
            **/
            @Search(name = "goodForKids",operator = Operator.like)
            private String goodForKids;

            /**
            * 酒类饮品
            **/
            @Search(name = "alcohol",operator = Operator.like)
            private String alcohol;

            /**
            * 是否提供外送
            **/
            @Search(name = "delivery",operator = Operator.like)
            private String delivery;

            /**
            * Wi-Fi
            **/
            @Search(name = "wifi",operator = Operator.like)
            private String wifi;

            /**
            * 是否承办宴席
            **/
            @Search(name = "caters",operator = Operator.like)
            private String caters;

            /**
            * 噪音音量
            **/
            @Search(name = "noiseLevel",operator = Operator.like)
            private String noiseLevel;

            /**
            * 是否有服务生服务
            **/
            @Search(name = "tableService",operator = Operator.like)
            private String tableService;

            /**
            * 适合早餐
            **/
            @Search(name = "goodForMealBreakfast",operator = Operator.like)
            private String goodForMealBreakfast;

            /**
            * 投票1
            **/
            @Search(name = "vote1",operator = Operator.eq)
            private Integer vote1;

            /**
            * 预定
            **/
            @Search(name = "reservations",operator = Operator.like)
            private String reservations;

            /**
            * 环境氛围
            **/
            @Search(name = "ambience",operator = Operator.like)
            private String ambience;

            /**
            * 投票3
            **/
            @Search(name = "vote3",operator = Operator.eq)
            private Integer vote3;

            /**
            * 评论
            **/
            @Search(name = "comment",operator = Operator.like)
            private String comment;

            /**
            * 投票2
            **/
            @Search(name = "vote2",operator = Operator.eq)
            private Integer vote2;

            /**
            * 是否有电视
            **/
            @Search(name = "hasTV",operator = Operator.like)
            private String hasTV;



}