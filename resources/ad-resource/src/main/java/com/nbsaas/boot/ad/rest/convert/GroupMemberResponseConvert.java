package com.nbsaas.boot.ad.rest.convert;

import com.nbsaas.boot.chat.data.entity.GroupMember;
import com.nbsaas.boot.ad.api.domain.response.GroupMemberResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class GroupMemberResponseConvert  implements Converter
<GroupMemberResponse,GroupMember> {

@Override
public GroupMemberResponse convert(GroupMember source) {
GroupMemberResponse  result = new  GroupMemberResponse();
BeanDataUtils.copyProperties(source, result);
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
return result;
}

}

