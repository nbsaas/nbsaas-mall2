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
public class ShopDataRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        private Float overallRating;
        private Double latitude;
        private Double longitude;
        private Long id;
        private Date addDate;
        private Integer photos;
        private Integer discountNum;
        private String phone;
        private Integer grouponNum;
        private Integer favoriteNum;
        private Integer commentNum;
        private Date lastDate;
        private String detailUrl;
        private String website;
        private String poi;
        private Float tasteRating;
        private String shopHours;
        private Float technologyRating;
        private String address;
        private Float serviceRating;
        private Integer checkinNum;
        private String image;
        private Float hygieneRating;
        private Float environmentRating;
        private Float price;
        private Float facilityRating;
        private Float imageNum;
        private Integer state;
        private String name;
        private Integer distance;
}