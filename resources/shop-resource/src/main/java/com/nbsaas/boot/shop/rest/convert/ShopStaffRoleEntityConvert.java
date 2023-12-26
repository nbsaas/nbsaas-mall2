package com.nbsaas.boot.shop.rest.convert;

import com.nbsaas.boot.shop.data.entity.ShopStaffRole;
import com.nbsaas.boot.shop.api.domain.request.ShopStaffRoleRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.boot.shop.data.entity.Shop;
            import com.nbsaas.boot.shop.data.entity.ShopRole;
            import com.nbsaas.boot.shop.data.entity.ShopStaff;

/**
* 请求对象转换成实体对象
*/

public class ShopStaffRoleEntityConvert  implements Converter<ShopStaffRole, ShopStaffRoleRequest> {

    @Override
    public ShopStaffRole convert(ShopStaffRoleRequest source) {
        ShopStaffRole result = new ShopStaffRole();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getShop()!=null){
                    Shop shop =new Shop();
                    shop.setId(source.getShop());
                    result.setShop(shop);
                    }
                    if(source.getShopRole()!=null){
                    ShopRole shopRole =new ShopRole();
                    shopRole.setId(source.getShopRole());
                    result.setShopRole(shopRole);
                    }
                    if(source.getShopStaff()!=null){
                    ShopStaff shopStaff =new ShopStaff();
                    shopStaff.setId(source.getShopStaff());
                    result.setShopStaff(shopStaff);
                    }
        return result;
    }
}

