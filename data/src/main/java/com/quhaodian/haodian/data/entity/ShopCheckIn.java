package com.quhaodian.haodian.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.quhaodian.data.entity.AbstractEntity;
import com.quhaodian.user.data.entity.UserInfo;

/**
 * Created by 年高 on 2015/11/22.
 */

/**
 * 用户签到功能
 */

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
    @JoinColumn(name = "shopid")
    private Shop shop;


    /**
     * 签到用户
     */
    @ManyToOne
    @JoinColumn(name = "userid")
    private UserInfo user;


    /**
     * 签到时间的心情
     */
    private String comment;


    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
