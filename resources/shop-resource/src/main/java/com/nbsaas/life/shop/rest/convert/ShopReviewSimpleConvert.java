package com.nbsaas.life.shop.rest.convert;

import com.nbsaas.life.shop.data.entity.ShopReview;
import com.nbsaas.life.shop.api.domain.simple.ShopReviewSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class ShopReviewSimpleConvert implements Converter<ShopReviewSimple, ShopReview> {




@Override
public ShopReviewSimple convert(ShopReview source) {
    ShopReviewSimple result = new ShopReviewSimple();

                result.setParking(source.getParking());
                result.setAttire(source.getAttire());
                result.setTakeout(source.getTakeout());
                result.setPriceScore(source.getPriceScore());
                result.setOutdoorSeating(source.getOutdoorSeating());
                result.setBusinessAcceptsCreditCards(source.getBusinessAcceptsCreditCards());
                result.setServiceScore(source.getServiceScore());
                result.setBikeParking(source.getBikeParking());
                result.setGoodForGroups(source.getGoodForGroups());
                result.setId(source.getId());
                result.setGoodForKids(source.getGoodForKids());
                result.setLastDate(source.getLastDate());
                result.setAlcohol(source.getAlcohol());
                result.setDelivery(source.getDelivery());
                result.setWifi(source.getWifi());
                result.setCaters(source.getCaters());
                result.setAddDate(source.getAddDate());
                result.setNoiseLevel(source.getNoiseLevel());
                result.setTableService(source.getTableService());
                result.setGoodForMealBreakfast(source.getGoodForMealBreakfast());
                result.setVote1(source.getVote1());
                result.setReservations(source.getReservations());
                result.setAmbience(source.getAmbience());
                result.setVote3(source.getVote3());
                result.setComment(source.getComment());
                result.setVote2(source.getVote2());
                result.setHasTV(source.getHasTV());


    return result;
}

}