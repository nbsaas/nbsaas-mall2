package com.nbsaas.life.shop.rest.resource;

import com.nbsaas.life.shop.api.apis.ShopStaffApi;
import com.nbsaas.life.shop.data.entity.ShopStaff;
import com.nbsaas.life.shop.api.domain.request.ShopStaffRequest;
import com.nbsaas.life.shop.api.domain.response.ShopStaffResponse;
import com.nbsaas.life.shop.api.domain.simple.ShopStaffSimple;
import com.nbsaas.life.shop.rest.convert.ShopStaffSimpleConvert;
import com.nbsaas.life.shop.rest.convert.ShopStaffEntityConvert;
import com.nbsaas.life.shop.rest.convert.ShopStaffResponseConvert;
import com.nbsaas.life.shop.data.repository.ShopStaffRepository;

import java.io.Serializable;
import com.nbsaas.boot.jpa.data.core.BaseResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.function.Function;
/**
*   业务接口实现
*/
@Transactional
@Service
public class ShopStaffResource extends BaseResource<ShopStaff,ShopStaffResponse, ShopStaffSimple, ShopStaffRequest>  implements ShopStaffApi {

    @Resource
    private ShopStaffRepository shopStaffRepository;

    @Override
    public JpaRepositoryImplementation<ShopStaff, Serializable> getJpaRepository() {
        return shopStaffRepository;
    }

    @Override
    public Function<ShopStaff, ShopStaffSimple> getConvertSimple() {
        return new ShopStaffSimpleConvert();
    }

    @Override
    public Function<ShopStaffRequest, ShopStaff> getConvertForm() {
        return new ShopStaffEntityConvert();
    }

    @Override
    public Function<ShopStaff, ShopStaffResponse> getConvertResponse() {
    return new ShopStaffResponseConvert();
    }




}


