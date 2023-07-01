package com.nbsaas.boot.ad.rest.resource;

import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.ad.api.apis.GroupRoomApi;
import com.nbsaas.boot.chat.data.entity.GroupRoom;
import com.nbsaas.boot.ad.api.domain.request.GroupRoomDataRequest;
import com.nbsaas.boot.ad.api.domain.request.GroupRoomSearchRequest;
import com.nbsaas.boot.ad.api.domain.response.GroupRoomResponse;
import com.nbsaas.boot.ad.api.domain.simple.GroupRoomSimple;
import com.nbsaas.boot.ad.rest.convert.GroupRoomSimpleConvert;
import com.nbsaas.boot.ad.rest.convert.GroupRoomEntityConvert;
import com.nbsaas.boot.ad.rest.convert.GroupRoomResponseConvert;
import com.nbsaas.boot.ad.data.repository.GroupRoomRepository;

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
public class GroupRoomResource extends BaseResource<GroupRoom,GroupRoomResponse, GroupRoomSimple, GroupRoomDataRequest>  implements GroupRoomApi {

    @Resource
    private GroupRoomRepository groupRoomRepository;

    @Override
    public JpaRepositoryImplementation<GroupRoom, Serializable> getJpaRepository() {
        return groupRoomRepository;
    }

    @Override
    public Function<GroupRoom, GroupRoomSimple> getConvertSimple() {
        return new GroupRoomSimpleConvert();
    }

    @Override
    public Function<GroupRoomDataRequest, GroupRoom> getConvertForm() {
        return new GroupRoomEntityConvert();
    }

    @Override
    public Function<GroupRoom, GroupRoomResponse> getConvertResponse() {
    return new GroupRoomResponseConvert();
    }




}


