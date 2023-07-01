package com.nbsaas.boot.ad.rest.convert;

import com.nbsaas.boot.chat.data.entity.GroupMessage;
import com.nbsaas.boot.ad.api.domain.simple.GroupMessageSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class GroupMessageSimpleConvert implements Converter<GroupMessageSimple, GroupMessage> {




@Override
public GroupMessageSimple convert(GroupMessage source) {
    GroupMessageSimple result = new GroupMessageSimple();

                result.setNote(source.getNote());
                result.setName(source.getName());
                if(source.getMember()!=null){
                    result.setMember(source.getMember().getId());
                }
                if(source.getMember()!=null){
                    result.setMemberName(source.getMember().getName());
                }
                result.setId(source.getId());
                result.setAddDate(source.getAddDate());
                result.setLastDate(source.getLastDate());


    return result;
}

}