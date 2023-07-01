package com.nbsaas.boot.ad.rest.convert;

import com.nbsaas.boot.chat.data.entity.GroupRoom;
import com.nbsaas.boot.ad.api.domain.response.GroupRoomResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class GroupRoomResponseConvert  implements Converter
<GroupRoomResponse,GroupRoom> {

@Override
public GroupRoomResponse convert(GroupRoom source) {
GroupRoomResponse  result = new  GroupRoomResponse();
BeanDataUtils.copyProperties(source, result);
            if(source.getLastMember()!=null){
                result.setLastMemberName(source.getLastMember().getName());
            }
            if(source.getLastMember()!=null){
                result.setLastMember(source.getLastMember().getId());
            }
return result;
}

}

