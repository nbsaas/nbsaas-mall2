package com.nbsaas.life.shop.rest.convert;

import com.nbsaas.life.shop.data.entity.Shop;
import com.nbsaas.life.shop.api.domain.simple.ShopSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class ShopSimpleConvert implements Converter<ShopSimple, Shop> {




    @Override
    public ShopSimple convert(Shop source) {
        ShopSimple result = new ShopSimple();

                    result.setOverallRating(source.getOverallRating());
                    result.setLatitude(source.getLatitude());
                    result.setLongitude(source.getLongitude());
                    result.setId(source.getId());
                    result.setAddDate(source.getAddDate());
                    result.setPhotos(source.getPhotos());
                    result.setDiscountNum(source.getDiscountNum());
                    result.setPhone(source.getPhone());
                    result.setGrouponNum(source.getGrouponNum());
                    result.setFavoriteNum(source.getFavoriteNum());
                    result.setCommentNum(source.getCommentNum());
                    result.setLastDate(source.getLastDate());
                    result.setDetailUrl(source.getDetailUrl());
                    result.setWebsite(source.getWebsite());
                    result.setPoi(source.getPoi());
                    result.setTasteRating(source.getTasteRating());
                    result.setShopHours(source.getShopHours());
                    result.setTechnologyRating(source.getTechnologyRating());
                    result.setAddress(source.getAddress());
                    result.setServiceRating(source.getServiceRating());
                    result.setCheckinNum(source.getCheckinNum());
                    result.setImage(source.getImage());
                    result.setHygieneRating(source.getHygieneRating());
                    result.setEnvironmentRating(source.getEnvironmentRating());
                    result.setPrice(source.getPrice());
                    result.setFacilityRating(source.getFacilityRating());
                    result.setImageNum(source.getImageNum());
                    result.setState(source.getState());
                    result.setName(source.getName());
                    result.setDistance(source.getDistance());


    return result;
  }

}