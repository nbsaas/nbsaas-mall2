package com.nbsaas.life.user.rest.convert;

import com.nbsaas.life.user.data.entity.UserLoginLog;
import com.nbsaas.life.user.api.domain.simple.UserLoginLogSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class UserLoginLogSimpleConvert implements Converter<UserLoginLogSimple, UserLoginLog> {




    @Override
    public UserLoginLogSimple convert(UserLoginLog source) {
        UserLoginLogSimple result = new UserLoginLogSimple();

                    result.setStoreState(source.getStoreState());
                    result.setPassword(source.getPassword());
                    if(source.getUser()!=null){
                    result.setUser(source.getUser().getId());
                    }
                    result.setIp(source.getIp());
                    result.setLastDate(source.getLastDate());
                    if(source.getUser()!=null){
                    result.setUserName(source.getUser().getName());
                    }
                    result.setId(source.getId());
                    result.setClient(source.getClient());
                    result.setAddDate(source.getAddDate());
                    result.setNote(source.getNote());
                    result.setAccount(source.getAccount());
                    result.setState(source.getState());


    return result;
  }

}