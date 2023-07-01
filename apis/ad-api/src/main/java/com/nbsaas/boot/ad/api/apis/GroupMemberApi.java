package com.nbsaas.boot.ad.api.apis;

import com.nbsaas.boot.ad.api.domain.request.GroupMemberDataRequest;
import com.nbsaas.boot.ad.api.domain.simple.GroupMemberSimple;
import com.nbsaas.boot.ad.api.domain.response.GroupMemberResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface GroupMemberApi extends BaseApi<GroupMemberResponse, GroupMemberSimple, GroupMemberDataRequest> {


}
