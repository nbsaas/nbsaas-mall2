package com.nbsaas.boot.ad.rest.convert;

import com.nbsaas.boot.chat.data.entity.GroupRoom;
import com.nbsaas.boot.ad.api.domain.request.GroupRoomDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.boot.common.data.entity.Member;

/**
* 请求对象转换成实体对象
*/

public class GroupRoomEntityConvert  implements Converter<GroupRoom, GroupRoomDataRequest> {

    @Override
    public GroupRoom convert(GroupRoomDataRequest source) {
        GroupRoom result = new GroupRoom();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getLastMember()!=null){
                    Member lastMember =new Member();
                    lastMember.setId(source.getLastMember());
                    result.setLastMember(lastMember);
                    }
        return result;
    }
}

