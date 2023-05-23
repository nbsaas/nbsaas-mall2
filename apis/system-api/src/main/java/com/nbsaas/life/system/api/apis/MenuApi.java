package com.nbsaas.life.system.api.apis;

import com.nbsaas.life.system.api.domain.request.MenuDataRequest;
import com.nbsaas.life.system.api.domain.simple.MenuSimple;
import com.nbsaas.life.system.api.domain.response.MenuResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface MenuApi extends BaseApi<MenuResponse, MenuSimple, MenuDataRequest> {


}
