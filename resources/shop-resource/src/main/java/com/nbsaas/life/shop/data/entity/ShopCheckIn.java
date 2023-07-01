package com.nbsaas.life.shop.data.entity;


import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.life.user.data.entity.UserInfo;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by 年高 on 2015/11/22.
 */

/**
 * 用户签到功能
 */
@Data
@Entity
@Table(name = "shop_checkin")
public class ShopCheckIn extends AbstractEntity {


    /**
     * gps信息
     */
    @Column(length = 100)
    private String gps;


    /**
     * 经度
     */
    private Double longitude;

    /**
     * 纬度
     */
    private Double latitude;

    /**
     * 签到的商铺
     */
    @ManyToOne
    private Shop shop;


    /**
     * 签到用户
     */
    @ManyToOne
    private UserInfo user;


    /**
     * 签到时间的心情
     */
    private String comment;


}
