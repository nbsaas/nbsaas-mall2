package com.nbsaas.life.user.rest.convert;

import com.nbsaas.life.user.data.entity.UserInfo;
import com.nbsaas.life.user.api.domain.simple.UserInfoSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class UserInfoSimpleConvert implements Converter<UserInfoSimple, UserInfo> {




@Override
public UserInfoSimple convert(UserInfo source) {
    UserInfoSimple result = new UserInfoSimple();

                result.setPhone(source.getPhone());
                result.setCatalog(source.getCatalog());
                result.setName(source.getName());
                if(source.getStoreState()!=null){
                    result.setStoreStateName(String.valueOf(source.getStoreState()));
                }
                result.setStoreState(source.getStoreState());
                result.setAvatar(source.getAvatar());
                result.setId(source.getId());
                result.setAddDate(source.getAddDate());
                result.setLoginSize(source.getLoginSize());
                result.setLastDate(source.getLastDate());


    return result;
}

}