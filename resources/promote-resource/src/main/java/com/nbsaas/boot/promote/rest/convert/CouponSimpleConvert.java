package com.nbsaas.boot.promote.rest.convert;

import com.nbsaas.boot.promote.data.entity.Coupon;
import com.nbsaas.boot.promote.api.domain.simple.CouponSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/

public class CouponSimpleConvert implements Converter<CouponSimple, Coupon> {




@Override
public CouponSimple convert(Coupon source) {
    CouponSimple result = new CouponSimple();

                result.setUseEndTime(source.getUseEndTime());
                result.setOrderAmount(source.getOrderAmount());
                if(source.getShop()!=null){
                    result.setShop(source.getShop().getId());
                }
                result.setExpireType(source.getExpireType());
                result.setName(source.getName());
                result.setDiscountAmount(source.getDiscountAmount());
                result.setUseBeginTime(source.getUseBeginTime());
                result.setId(source.getId());
                if(source.getCustomer()!=null){
                    result.setCustomerName(source.getCustomer().getName());
                }
                if(source.getCustomer()!=null){
                    result.setCustomer(source.getCustomer().getId());
                }


    return result;
}

}