package com.nbsaas.boot.ad.rest.resource;

import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.ad.api.apis.GroupMessageApi;
import com.nbsaas.boot.chat.data.entity.GroupMessage;
import com.nbsaas.boot.ad.api.domain.request.GroupMessageDataRequest;
import com.nbsaas.boot.ad.api.domain.request.GroupMessageSearchRequest;
import com.nbsaas.boot.ad.api.domain.response.GroupMessageResponse;
import com.nbsaas.boot.ad.api.domain.simple.GroupMessageSimple;
import com.nbsaas.boot.ad.rest.convert.GroupMessageSimpleConvert;
import com.nbsaas.boot.ad.rest.convert.GroupMessageEntityConvert;
import com.nbsaas.boot.ad.rest.convert.GroupMessageResponseConvert;
import com.nbsaas.boot.ad.data.repository.GroupMessageRepository;

import java.io.Serializable;
import com.nbsaas.boot.jpa.data.core.BaseResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

/**
*   业务接口实现
*/
@Transactional
@Service
public class GroupMessageResource extends BaseResource<GroupMessage,GroupMessageResponse, GroupMessageSimple, GroupMessageDataRequest>  implements GroupMessageApi {

    @Resource
    private GroupMessageRepository groupMessageRepository;

    @Override
    public JpaRepositoryImplementation<GroupMessage, Serializable> getJpaRepository() {
        return groupMessageRepository;
    }

    @Override
    public Function<GroupMessage, GroupMessageSimple> getConvertSimple() {
        return new GroupMessageSimpleConvert();
    }

    @Override
    public Function<GroupMessageDataRequest, GroupMessage> getConvertForm() {
        return new GroupMessageEntityConvert();
    }

    @Override
    public Function<GroupMessage, GroupMessageResponse> getConvertResponse() {
    return new GroupMessageResponseConvert();
    }




}


