package com.nbsaas.life.shop.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;

/**
* 列表对象
*/
@Data
public class ShopSimple implements Serializable {

    /**
    * 序列化参数
    */
    private static final long serialVersionUID = 1L;


            private Float overallRating;
            private Double latitude;
            private Double longitude;
            private Long id;
                //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
            private Date addDate;
            private Integer photos;
            private Integer discountNum;
            private String phone;
            private Integer grouponNum;
            private Integer favoriteNum;
            private Integer commentNum;
                //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
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