package com.nbsaas.life.shop.rest.convert;

import com.nbsaas.life.shop.data.entity.ShopStaff;
import com.nbsaas.life.shop.api.domain.request.ShopStaffRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.life.shop.data.entity.Shop;
            import com.nbsaas.boot.jpa.data.entity.User;

/**
* 请求对象转换成实体对象
*/

public class ShopStaffEntityConvert  implements Converter<ShopStaff, ShopStaffRequest> {

    @Override
    public ShopStaff convert(ShopStaffRequest source) {
        ShopStaff result = new ShopStaff();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getShop()!=null){
                    Shop shop =new Shop();
                    shop.setId(source.getShop());
                    result.setShop(shop);
                    }
                    if(source.getUser()!=null){
                    User user =new User();
                    user.setId(source.getUser());
                    result.setUser(user);
                    }
        return result;
    }
}

