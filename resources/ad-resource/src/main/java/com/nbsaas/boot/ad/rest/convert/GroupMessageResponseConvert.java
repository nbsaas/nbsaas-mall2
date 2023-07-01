package com.nbsaas.boot.ad.rest.convert;

import com.nbsaas.boot.chat.data.entity.GroupMessage;
import com.nbsaas.boot.ad.api.domain.response.GroupMessageResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class GroupMessageResponseConvert  implements Converter
<GroupMessageResponse,GroupMessage> {

@Override
public GroupMessageResponse convert(GroupMessage source) {
GroupMessageResponse  result = new  GroupMessageResponse();
BeanDataUtils.copyProperties(source, result);
            if(source.getMember()!=null){
                result.setMember(source.getMember().getId());
            }
            if(source.getMember()!=null){
                result.setMemberName(source.getMember().getName());
            }
return result;
}

}

