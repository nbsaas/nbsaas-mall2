package com.nbsaas.boot.aop;


import com.nbsaas.boot.shop.api.domain.response.ShopStaffResponse;
import com.nbsaas.boot.utils.UserUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

@Component
@Aspect
public class CommonPointcuts {


    @Before("@annotation(com.nbsaas.boot.rest.annotations.CreateData)")
    public void before(JoinPoint point) {

        Object[] args = point.getArgs();
        if (args != null && args.length > 0) {
            Object object = args[0];
            ShopStaffResponse user = UserUtils.user();

            setValue(object, "createUser", user.getStaff());
            setValue(object, "addDate", new Date());
            setValue(object, "staff", user.getId());
            setValue(object, "shop", user.getShop());
            setValue(object, "updateUser", user.getStaff());
            setValue(object, "lastDate", new Date());
        }
        // ...
    }

    @Before("@annotation(com.nbsaas.boot.rest.annotations.SearchData)")
    public void search(JoinPoint point) {

        Object[] args = point.getArgs();
        if (args != null && args.length > 0) {
            Object object = args[0];
            ShopStaffResponse user = UserUtils.user();
            setValue(object, "shop", user.getShop());
        }
    }
    @Before("@annotation(com.nbsaas.boot.rest.annotations.UpdateData)")
    public void updateData(JoinPoint point) {
        Object[] args = point.getArgs();
        if (args != null && args.length > 0) {
            Object object = args[0];
            ShopStaffResponse user = UserUtils.user();

            setValue(object, "updateUser", user.getId());
        }
    }

    public void setValue(Object object, String filed, Object value) {
        try {
            BeanUtils.setProperty(object, filed, value);
        } catch (IllegalAccessException | InvocationTargetException ignored) {

        }
    }




}
