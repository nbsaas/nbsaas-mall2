package com.nbsaas.boot.ad.rest.convert;

import com.nbsaas.boot.chat.data.entity.GroupRoom;
import com.nbsaas.boot.ad.api.domain.simple.GroupRoomSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class GroupRoomSimpleConvert implements Converter<GroupRoomSimple, GroupRoom> {




@Override
public GroupRoomSimple convert(GroupRoom source) {
    GroupRoomSimple result = new GroupRoomSimple();

                result.setName(source.getName());
                result.setLastNote(source.getLastNote());
                if(source.getLastMember()!=null){
                    result.setLastMemberName(source.getLastMember().getName());
                }
                if(source.getLastMember()!=null){
                    result.setLastMember(source.getLastMember().getId());
                }
                result.setId(source.getId());
                result.setAddDate(source.getAddDate());
                result.setLastDate(source.getLastDate());


    return result;
}

}