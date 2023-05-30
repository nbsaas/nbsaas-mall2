package com.nbsaas.life.user.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.life.user.api.domain.simple.UserLoginLogSimple;
import com.nbsaas.life.user.data.entity.UserLoginLog;
/**
* 列表对象转换器
*/

public class UserLoginLogSimpleConvert implements Converter<UserLoginLogSimple, UserLoginLog> {




    @Override
    public UserLoginLogSimple convert(UserLoginLog source) {
        UserLoginLogSimple result = new UserLoginLogSimple();

        result.setNote(source.getNote());
        result.setLastDate(source.getLastDate());
        result.setState(source.getState());
        result.setId(source.getId());
        result.setStoreState(source.getStoreState());
        result.setAccount(source.getAccount());
        if (source.getUser() != null) {
            result.setUser(source.getUser().getId());
        }
        result.setPassword(source.getPassword());
        result.setIp(source.getIp());
        if (source.getUser() != null) {
            result.setUserName(source.getUser().getName());
        }
                    result.setClient(source.getClient());
                    result.setAddDate(source.getAddDate());


    return result;
  }

}