package com.nbsaas.boot.shop.rest.convert;

import com.nbsaas.boot.shop.data.entity.ShopCheckIn;
import com.nbsaas.boot.shop.api.domain.simple.ShopCheckInSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/

public class ShopCheckInSimpleConvert implements Converter<ShopCheckInSimple, ShopCheckIn> {




@Override
public ShopCheckInSimple convert(ShopCheckIn source) {
    ShopCheckInSimple result = new ShopCheckInSimple();

                result.setLatitude(source.getLatitude());
                result.setComment(source.getComment());
                result.setGps(source.getGps());
                result.setId(source.getId());
                result.setAddDate(source.getAddDate());
                result.setLongitude(source.getLongitude());
                result.setLastDate(source.getLastDate());


    return result;
}

}