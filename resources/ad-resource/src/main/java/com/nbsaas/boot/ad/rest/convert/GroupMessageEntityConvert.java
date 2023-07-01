package com.nbsaas.boot.ad.rest.convert;

import com.nbsaas.boot.chat.data.entity.GroupMessage;
import com.nbsaas.boot.ad.api.domain.request.GroupMessageDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.boot.common.data.entity.Member;

/**
* 请求对象转换成实体对象
*/

public class GroupMessageEntityConvert  implements Converter<GroupMessage, GroupMessageDataRequest> {

    @Override
    public GroupMessage convert(GroupMessageDataRequest source) {
        GroupMessage result = new GroupMessage();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getMember()!=null){
                    Member member =new Member();
                    member.setId(source.getMember());
                    result.setMember(member);
                    }
        return result;
    }
}

