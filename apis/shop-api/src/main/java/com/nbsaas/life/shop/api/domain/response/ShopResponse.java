package com.nbsaas.life.shop.api.domain.response;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date lastDate;

        private String address;

        private Double longitude;

        private Float overallRating;

        private Long city;

        private Integer photos;

        private Float serviceRating;

        private Float tasteRating;

        private Double latitude;

        private String image;

        private Integer discountNum;

        private String shopHours;

        private Long id;

        private Long province;

        private String phone;

        private Integer checkinNum;

        private Float price;

        private Integer grouponNum;

        private Float technologyRating;

        private Float imageNum;

        private String website;

        private Integer distance;

        private Float facilityRating;

        private Integer state;

        private String detailUrl;

        private Integer favoriteNum;

        private String poi;

        private Long user;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date addDate;

        private Float hygieneRating;

        private String name;

        private Long area;

        private Integer commentNum;

        private Float environmentRating;


}