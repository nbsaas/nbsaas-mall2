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

                result.setNote(source.getNote());
                result.setPassword(source.getPassword());
                result.setIp(source.getIp());
                result.setClient(source.getClient());
                if(source.getStoreState()!=null){
                    result.setStoreStateName(String.valueOf(source.getStoreState()));
                }
                result.setStoreState(source.getStoreState());
                if(source.getState()!=null){
                    result.setStateName(String.valueOf(source.getState()));
                }
                result.setState(source.getState());
                result.setId(source.getId());
                if(source.getUser()!=null){
                    result.setUserName(source.getUser().getName());
                }
                if(source.getUser()!=null){
                    result.setUser(source.getUser().getId());
                }
                result.setAddDate(source.getAddDate());
                result.setAccount(source.getAccount());
                result.setLastDate(source.getLastDate());


    return result;
}

}