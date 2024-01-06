package com.nbsaas.boot.shop.ext.apis;

import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.shop.api.domain.response.ShopStaffResponse;
import com.nbsaas.boot.shop.ext.domain.request.ShopStaffExtRequest;

public interface ShopStaffExtApi {

    ResponseObject<ShopStaffResponse> findByUserId(Long userId);


    /**
     * 添加店员
     *
     * @param request
     * @return
     */
    ResponseObject<?> create(ShopStaffExtRequest request);


    /**
     * 更新店员信息
     *
     * @param request
     * @return
     */
    ResponseObject<?> update(ShopStaffExtRequest request);

    /**
     * 重置该员工密码
     * @param request
     * @return
     */
    ResponseObject<?> restPassword(ShopStaffExtRequest request);

}
