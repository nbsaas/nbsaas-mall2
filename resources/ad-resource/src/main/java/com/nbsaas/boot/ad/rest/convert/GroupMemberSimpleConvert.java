package com.nbsaas.boot.ad.rest.convert;

import com.nbsaas.boot.chat.data.entity.GroupMember;
import com.nbsaas.boot.ad.api.domain.simple.GroupMemberSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class GroupMemberSimpleConvert implements Converter<GroupMemberSimple, GroupMember> {




@Override
public GroupMemberSimple convert(GroupMember source) {
    GroupMemberSimple result = new GroupMemberSimple();

                if(source.getGroupRoom()!=null){
                    result.setGroupRoom(source.getGroupRoom().getId());
                }
                if(source.getGroupRoom()!=null){
                    result.setGroupRoomName(source.getGroupRoom().getName());
                }
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