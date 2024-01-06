package com.nbsaas.boot.shop.rest.convert;

import com.nbsaas.boot.shop.data.entity.ShopHotWord;
import com.nbsaas.boot.shop.api.domain.request.ShopHotWordRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.boot.shop.data.entity.Shop;
            import com.nbsaas.boot.shop.data.entity.ShopStaff;

/**
* 请求对象转换成实体对象
*/

public class ShopHotWordEntityConvert  implements Converter<ShopHotWord, ShopHotWordRequest> {

    @Override
    public ShopHotWord convert(ShopHotWordRequest source) {
        ShopHotWord result = new ShopHotWord();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getShop()!=null){
                    Shop shop =new Shop();
                    shop.setId(source.getShop());
                    result.setShop(shop);
                    }
                    if(source.getStaff()!=null){
                    ShopStaff staff =new ShopStaff();
                    staff.setId(source.getStaff());
                    result.setStaff(staff);
                    }
        return result;
    }
}

