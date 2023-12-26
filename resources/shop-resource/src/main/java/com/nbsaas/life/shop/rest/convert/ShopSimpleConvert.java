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

                result.setDiscountNum(source.getDiscountNum());
                result.setDistance(source.getDistance());
                if(source.getCity()!=null){
                    result.setCity(source.getCity().getId());
                }
                result.setFacilityRating(source.getFacilityRating());
                result.setLatitude(source.getLatitude());
                result.setGrouponNum(source.getGrouponNum());
                result.setPoi(source.getPoi());
                result.setPhotos(source.getPhotos());
                result.setEnvironmentRating(source.getEnvironmentRating());
                if(source.getProvince()!=null){
                    result.setProvince(source.getProvince().getId());
                }
                result.setPrice(source.getPrice());
                result.setState(source.getState());
                result.setId(source.getId());
                result.setLongitude(source.getLongitude());
                result.setTasteRating(source.getTasteRating());
                result.setLastDate(source.getLastDate());
                result.setHygieneRating(source.getHygieneRating());
                if(source.getArea()!=null){
                    result.setArea(source.getArea().getId());
                }
                result.setImage(source.getImage());
                result.setWebsite(source.getWebsite());
                result.setAddress(source.getAddress());
                result.setOverallRating(source.getOverallRating());
                result.setImageNum(source.getImageNum());
                result.setServiceRating(source.getServiceRating());
                result.setShopHours(source.getShopHours());
                result.setAddDate(source.getAddDate());
                result.setFavoriteNum(source.getFavoriteNum());
                result.setCommentNum(source.getCommentNum());
                result.setPhone(source.getPhone());
                result.setName(source.getName());
                if(source.getStoreState()!=null){
                    result.setStoreStateName(String.valueOf(source.getStoreState()));
                }
                result.setStoreState(source.getStoreState());
                result.setDetailUrl(source.getDetailUrl());
                result.setTechnologyRating(source.getTechnologyRating());
                result.setCheckinNum(source.getCheckinNum());
                if(source.getUser()!=null){
                    result.setUser(source.getUser().getId());
                }


    return result;
}

}