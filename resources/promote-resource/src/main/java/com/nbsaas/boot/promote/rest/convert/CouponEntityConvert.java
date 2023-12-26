package com.nbsaas.boot.promote.rest.convert;

import com.nbsaas.boot.promote.data.entity.Coupon;
import com.nbsaas.boot.promote.api.domain.request.CouponRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.boot.shop.data.entity.Shop;
            import com.nbsaas.boot.customer.data.entity.Customer;

/**
* 请求对象转换成实体对象
*/

public class CouponEntityConvert  implements Converter<Coupon, CouponRequest> {

    @Override
    public Coupon convert(CouponRequest source) {
        Coupon result = new Coupon();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getShop()!=null){
                    Shop shop =new Shop();
                    shop.setId(source.getShop());
                    result.setShop(shop);
                    }
                    if(source.getCustomer()!=null){
                    Customer customer =new Customer();
                    customer.setId(source.getCustomer());
                    result.setCustomer(customer);
                    }
        return result;
    }
}

