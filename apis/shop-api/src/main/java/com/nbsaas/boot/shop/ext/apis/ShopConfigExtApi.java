package com.nbsaas.boot.shop.ext.apis;

import com.nbsaas.boot.rest.response.ResponseObject;

public interface ShopConfigExtApi {

    /**
     * 获取配置
     *
     * @param classKey
     * @param <T>
     * @return
     */
    <T> T config(Long shop,Class<T> classKey);

    <T> ResponseObject<T> info(Long shop,Class<T> classKey);

    <T> ResponseObject<T> configData(Long shop,T data);

    <T> T data(Long shop,T data);
}
