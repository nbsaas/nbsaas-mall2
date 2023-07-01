package com.nbsaas.boot.ad.rest.resource;

import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.ad.api.apis.GroupMemberApi;
import com.nbsaas.boot.chat.data.entity.GroupMember;
import com.nbsaas.boot.ad.api.domain.request.GroupMemberDataRequest;
import com.nbsaas.boot.ad.api.domain.request.GroupMemberSearchRequest;
import com.nbsaas.boot.ad.api.domain.response.GroupMemberResponse;
import com.nbsaas.boot.ad.api.domain.simple.GroupMemberSimple;
import com.nbsaas.boot.ad.rest.convert.GroupMemberSimpleConvert;
import com.nbsaas.boot.ad.rest.convert.GroupMemberEntityConvert;
import com.nbsaas.boot.ad.rest.convert.GroupMemberResponseConvert;
import com.nbsaas.boot.ad.data.repository.GroupMemberRepository;

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
public class GroupMemberResource extends BaseResource<GroupMember,GroupMemberResponse, GroupMemberSimple, GroupMemberDataRequest>  implements GroupMemberApi {

    @Resource
    private GroupMemberRepository groupMemberRepository;

    @Override
    public JpaRepositoryImplementation<GroupMember, Serializable> getJpaRepository() {
        return groupMemberRepository;
    }

    @Override
    public Function<GroupMember, GroupMemberSimple> getConvertSimple() {
        return new GroupMemberSimpleConvert();
    }

    @Override
    public Function<GroupMemberDataRequest, GroupMember> getConvertForm() {
        return new GroupMemberEntityConvert();
    }

    @Override
    public Function<GroupMember, GroupMemberResponse> getConvertResponse() {
    return new GroupMemberResponseConvert();
    }




}


