package com.nbsaas.boot.shop.rest.convert;

import com.nbsaas.boot.shop.data.entity.ShopRole;
import com.nbsaas.boot.shop.api.domain.request.ShopRoleRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.boot.shop.data.entity.Shop;

/**
* 请求对象转换成实体对象
*/

public class ShopRoleEntityConvert  implements Converter<ShopRole, ShopRoleRequest> {

    @Override
    public ShopRole convert(ShopRoleRequest source) {
        ShopRole result = new ShopRole();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getShop()!=null){
                    Shop shop =new Shop();
                    shop.setId(source.getShop());
                    result.setShop(shop);
                    }
        return result;
    }
}

