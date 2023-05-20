package com.nbsaas.life.shop.api.domain.request;

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
public class ShopSearchRequest   extends PageRequest implements Serializable {

    /**
    * 序列化参数
    */
    private static final long serialVersionUID = 1L;


                //
               @Search(name = "id",operator = Operator.eq)
                private Long id;
                //
               @Search(name = "photos",operator = Operator.eq)
                private Integer photos;
                //
               @Search(name = "discountNum",operator = Operator.eq)
                private Integer discountNum;
                //
               @Search(name = "phone",operator = Operator.like)
                private String phone;
                //
               @Search(name = "grouponNum",operator = Operator.eq)
                private Integer grouponNum;
                //
               @Search(name = "favoriteNum",operator = Operator.eq)
                private Integer favoriteNum;
                //
               @Search(name = "commentNum",operator = Operator.eq)
                private Integer commentNum;
                //
               @Search(name = "detailUrl",operator = Operator.like)
                private String detailUrl;
                //
               @Search(name = "website",operator = Operator.like)
                private String website;
                //
               @Search(name = "poi",operator = Operator.like)
                private String poi;
                //
               @Search(name = "shopHours",operator = Operator.like)
                private String shopHours;
                //
               @Search(name = "address",operator = Operator.like)
                private String address;
                //
               @Search(name = "checkinNum",operator = Operator.eq)
                private Integer checkinNum;
                //
               @Search(name = "image",operator = Operator.like)
                private String image;
                //
               @Search(name = "state",operator = Operator.eq)
                private Integer state;
                //
               @Search(name = "name",operator = Operator.like)
                private String name;
                //
               @Search(name = "distance",operator = Operator.eq)
                private Integer distance;


}