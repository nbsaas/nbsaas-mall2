package com.nbsaas.boot.utils;

import com.nbsaas.boot.shop.api.domain.response.ShopStaffResponse;
import com.nbsaas.boot.user.ext.domain.response.UserInfoExtResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.beans.BeanUtils;

public class UserUtils {

    public static ShopStaffResponse user(){
        Object obj = SecurityUtils.getSubject().getPrincipal();
        if (obj == null) {
            throw new UnauthenticatedException();
        }
        if (obj instanceof ShopStaffResponse){
            return (ShopStaffResponse) obj;
        }
        ShopStaffResponse result=new ShopStaffResponse();
        BeanUtils.copyProperties(obj,result);
        return result;
    }
}
