package com.nbsaas.boot.promote.rest.convert;

import com.nbsaas.boot.promote.data.entity.CouponRule;
import com.nbsaas.boot.promote.api.domain.simple.CouponRuleSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/

public class CouponRuleSimpleConvert implements Converter<CouponRuleSimple, CouponRule> {




@Override
public CouponRuleSimple convert(CouponRule source) {
    CouponRuleSimple result = new CouponRuleSimple();

                result.setLimitNum(source.getLimitNum());
                result.setNote(source.getNote());
                if(source.getShop()!=null){
                    result.setShop(source.getShop().getId());
                }
                if(source.getShop()!=null){
                    result.setShopName(source.getShop().getName());
                }
                result.setSendBeginTime(source.getSendBeginTime());
                result.setUseBeginTime(source.getUseBeginTime());
                result.setUseEndTime(source.getUseEndTime());
                result.setCouponScope(source.getCouponScope());
                result.setTakeawayRate(source.getTakeawayRate());
                result.setMoney(source.getMoney());
                result.setUseNum(source.getUseNum());
                result.setMinPrice(source.getMinPrice());
                result.setName(source.getName());
                result.setLogo(source.getLogo());
                if(source.getStoreState()!=null){
                    result.setStoreStateName(String.valueOf(source.getStoreState()));
                }
                result.setStoreState(source.getStoreState());
                result.setId(source.getId());
                result.setStock(source.getStock());
                result.setSendNum(source.getSendNum());
                result.setSendEndTime(source.getSendEndTime());
                result.setUseDay(source.getUseDay());


    return result;
}

}