package com.nbsaas.boot.promote.rest.convert;

import com.nbsaas.boot.promote.data.entity.CouponRule;
import com.nbsaas.boot.promote.api.domain.request.CouponRuleRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.boot.shop.data.entity.Shop;

/**
* 请求对象转换成实体对象
*/

public class CouponRuleEntityConvert  implements Converter<CouponRule, CouponRuleRequest> {

    @Override
    public CouponRule convert(CouponRuleRequest source) {
        CouponRule result = new CouponRule();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getShop()!=null){
                    Shop shop =new Shop();
                    shop.setId(source.getShop());
                    result.setShop(shop);
                    }
        return result;
    }
}

