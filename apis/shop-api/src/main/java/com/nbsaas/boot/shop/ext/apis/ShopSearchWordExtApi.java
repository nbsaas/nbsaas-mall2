package com.nbsaas.boot.shop.ext.apis;

import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.shop.api.domain.request.ShopSearchWordRequest;
import com.nbsaas.boot.shop.api.domain.response.ShopSearchWordResponse;

public interface ShopSearchWordExtApi {

    /**
     * 添加搜索词
     *
     * @param request
     * @return
     */
    ResponseObject<ShopSearchWordResponse> create(ShopSearchWordRequest request);
}
