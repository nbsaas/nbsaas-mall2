package com.nbsaas.boot.promote.rest.convert;

import com.nbsaas.boot.promote.data.entity.Coupon;
import com.nbsaas.boot.promote.api.domain.response.CouponResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
/**
* 实体对象转化成响应对象
*/

public class CouponResponseConvert  implements Converter<CouponResponse,Coupon> {

    @Override
    public CouponResponse convert(Coupon source) {
        CouponResponse  result = new  CouponResponse();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getShop()!=null){
                        result.setShop(source.getShop().getId());
                    }
                    if(source.getCustomer()!=null){
                        result.setCustomerName(source.getCustomer().getName());
                    }
                    if(source.getCustomer()!=null){
                        result.setCustomer(source.getCustomer().getId());
                    }
        return result;
    }

}

