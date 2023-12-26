package com.nbsaas.boot.promote.rest.convert;

import com.nbsaas.boot.promote.data.entity.CouponRule;
import com.nbsaas.boot.promote.api.domain.response.CouponRuleResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
/**
* 实体对象转化成响应对象
*/

public class CouponRuleResponseConvert  implements Converter<CouponRuleResponse,CouponRule> {

    @Override
    public CouponRuleResponse convert(CouponRule source) {
        CouponRuleResponse  result = new  CouponRuleResponse();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getShop()!=null){
                        result.setShop(source.getShop().getId());
                    }
                    if(source.getShop()!=null){
                        result.setShopName(source.getShop().getName());
                    }
                    if(source.getStoreState()!=null){
                        result.setStoreStateName(String.valueOf(source.getStoreState()));
                    }
        return result;
    }

}

