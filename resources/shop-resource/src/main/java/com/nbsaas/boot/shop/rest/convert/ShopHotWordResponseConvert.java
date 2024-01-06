package com.nbsaas.boot.shop.rest.convert;

import com.nbsaas.boot.shop.data.entity.ShopHotWord;
import com.nbsaas.boot.shop.api.domain.response.ShopHotWordResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
/**
* 实体对象转化成响应对象
*/

public class ShopHotWordResponseConvert  implements Converter<ShopHotWordResponse,ShopHotWord> {

    @Override
    public ShopHotWordResponse convert(ShopHotWord source) {
        ShopHotWordResponse  result = new  ShopHotWordResponse();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getShop()!=null){
                        result.setShop(source.getShop().getId());
                    }
                    if(source.getShop()!=null){
                        result.setShopName(source.getShop().getName());
                    }
                    if(source.getStaff()!=null){
                        result.setStaff(source.getStaff().getId());
                    }
        return result;
    }

}

