package com.nbsaas.boot.shop.rest.convert;

import com.nbsaas.boot.shop.data.entity.ShopStaffStructure;
import com.nbsaas.boot.shop.api.domain.request.ShopStaffStructureRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.boot.shop.data.entity.ShopStaffStructure;
            import com.nbsaas.boot.shop.data.entity.Shop;

/**
* 请求对象转换成实体对象
*/

public class ShopStaffStructureEntityConvert  implements Converter<ShopStaffStructure, ShopStaffStructureRequest> {

    @Override
    public ShopStaffStructure convert(ShopStaffStructureRequest source) {
        ShopStaffStructure result = new ShopStaffStructure();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getParent()!=null){
                    ShopStaffStructure parent =new ShopStaffStructure();
                    parent.setId(source.getParent());
                    result.setParent(parent);
                    }
                    if(source.getShop()!=null){
                    Shop shop =new Shop();
                    shop.setId(source.getShop());
                    result.setShop(shop);
                    }
        return result;
    }
}

