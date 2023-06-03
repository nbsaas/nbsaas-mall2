package com.nbsaas.life.shop.rest.convert;

import com.nbsaas.life.shop.data.entity.Shop;
import com.nbsaas.life.shop.api.domain.simple.ShopSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
 * 列表对象转换器
 */

public class ShopSimpleConvert implements Converter
        <ShopSimple, Shop> {


    @Override
    public ShopSimple convert(Shop source) {
        ShopSimple result = new ShopSimple();

        result.setLastDate(source.getLastDate());
        result.setAddress(source.getAddress());
        result.setLongitude(source.getLongitude());
        result.setOverallRating(source.getOverallRating());
        if (source.getCity() != null) {
            result.setCity(source.getCity().getId());
        }
        result.setPhotos(source.getPhotos());
        result.setServiceRating(source.getServiceRating());
        result.setTasteRating(source.getTasteRating());
        result.setLatitude(source.getLatitude());
        result.setImage(source.getImage());
        result.setDiscountNum(source.getDiscountNum());
        result.setShopHours(source.getShopHours());
        result.setId(source.getId());
        if (source.getProvince() != null) {
            result.setProvince(source.getProvince().getId());
        }
        result.setPhone(source.getPhone());
        result.setCheckinNum(source.getCheckinNum());
        result.setPrice(source.getPrice());
        result.setGrouponNum(source.getGrouponNum());
        result.setTechnologyRating(source.getTechnologyRating());
        result.setImageNum(source.getImageNum());
        result.setWebsite(source.getWebsite());
        result.setDistance(source.getDistance());
        result.setFacilityRating(source.getFacilityRating());
        result.setState(source.getState());
        result.setDetailUrl(source.getDetailUrl());
        result.setFavoriteNum(source.getFavoriteNum());
        result.setPoi(source.getPoi());
        if (source.getUser() != null) {
            result.setUser(source.getUser().getId());
        }
        result.setAddDate(source.getAddDate());
        result.setHygieneRating(source.getHygieneRating());
        result.setName(source.getName());
        if (source.getArea() != null) {
            result.setArea(source.getArea().getId());
        }
        result.setCommentNum(source.getCommentNum());
        result.setEnvironmentRating(source.getEnvironmentRating());


        return result;
    }

}