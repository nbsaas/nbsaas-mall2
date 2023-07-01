package com.nbsaas.boot.ad.rest.convert;

import com.nbsaas.boot.chat.data.entity.GroupMember;
import com.nbsaas.boot.ad.api.domain.request.GroupMemberDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.boot.chat.data.entity.GroupRoom;
            import com.nbsaas.boot.common.data.entity.Member;

/**
* 请求对象转换成实体对象
*/

public class GroupMemberEntityConvert  implements Converter<GroupMember, GroupMemberDataRequest> {

    @Override
    public GroupMember convert(GroupMemberDataRequest source) {
        GroupMember result = new GroupMember();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getGroupRoom()!=null){
                    GroupRoom groupRoom =new GroupRoom();
                    groupRoom.setId(source.getGroupRoom());
                    result.setGroupRoom(groupRoom);
                    }
                    if(source.getMember()!=null){
                    Member member =new Member();
                    member.setId(source.getMember());
                    result.setMember(member);
                    }
        return result;
    }
}

