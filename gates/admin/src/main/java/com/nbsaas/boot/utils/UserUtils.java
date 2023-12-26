package com.nbsaas.boot.utils;

import com.nbsaas.boot.user.ext.domain.response.UserInfoExtResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.beans.BeanUtils;

public class UserUtils {

    public static UserInfoExtResponse user(){
        Object obj = SecurityUtils.getSubject().getPrincipal();
        if (obj == null) {
            throw new UnauthenticatedException();
        }
        if (obj instanceof UserInfoExtResponse){
            return (UserInfoExtResponse) obj;
        }
        UserInfoExtResponse result=new UserInfoExtResponse();
        BeanUtils.copyProperties(obj,result);
        return result;
    }
}
