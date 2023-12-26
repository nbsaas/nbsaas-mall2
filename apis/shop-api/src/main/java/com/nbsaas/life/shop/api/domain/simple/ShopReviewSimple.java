package com.nbsaas.life.shop.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;

/**
* 列表对象
*/
@Data
public class ShopReviewSimple implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;




            /**
            * 停车场
            **/
                private String parking;

            /**
            * 衣著
            **/
                private String attire;

            /**
            * 是否接受外带
            **/
                private String takeout;

            /**
            * 价格评分
            **/
                private Integer priceScore;

            /**
            * 是否提供户外座位
            **/
                private String outdoorSeating;

            /**
            * 是否接受信用卡
            **/
                private String businessAcceptsCreditCards;

            /**
            * 服务评分
            **/
                private Integer serviceScore;

            /**
            * 是否有单车停车位
            **/
                private String bikeParking;

            /**
            * 是否适合团体
            **/
                private String goodForGroups;

            /**
            * 主键id
            **/
                private Long id;

            /**
            * 是否适合儿童
            **/
                private String goodForKids;

            /**
            * 最新修改时间
            **/
                private Date lastDate;

            /**
            * 酒类饮品
            **/
                private String alcohol;

            /**
            * 是否提供外送
            **/
                private String delivery;

            /**
            * Wi-Fi
            **/
                private String wifi;

            /**
            * 是否承办宴席
            **/
                private String caters;

            /**
            * 添加时间
            **/
                private Date addDate;

            /**
            * 噪音音量
            **/
                private String noiseLevel;

            /**
            * 是否有服务生服务
            **/
                private String tableService;

            /**
            * 适合早餐
            **/
                private String goodForMealBreakfast;

            /**
            * 投票1
            **/
                private Integer vote1;

            /**
            * 预定
            **/
                private String reservations;

            /**
            * 环境氛围
            **/
                private String ambience;

            /**
            * 投票3
            **/
                private Integer vote3;

            /**
            * 评论
            **/
                private String comment;

            /**
            * 投票2
            **/
                private Integer vote2;

            /**
            * 是否有电视
            **/
                private String hasTV;


}