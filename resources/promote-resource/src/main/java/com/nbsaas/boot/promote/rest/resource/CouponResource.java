package com.nbsaas.boot.promote.rest.resource;

import com.nbsaas.boot.promote.api.apis.CouponApi;
import com.nbsaas.boot.promote.data.entity.Coupon;
import com.nbsaas.boot.promote.api.domain.request.CouponRequest;
import com.nbsaas.boot.promote.api.domain.response.CouponResponse;
import com.nbsaas.boot.promote.api.domain.simple.CouponSimple;
import com.nbsaas.boot.promote.rest.convert.CouponSimpleConvert;
import com.nbsaas.boot.promote.rest.convert.CouponEntityConvert;
import com.nbsaas.boot.promote.rest.convert.CouponResponseConvert;
import com.nbsaas.boot.promote.data.repository.CouponRepository;

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
public class CouponResource extends BaseResource<Coupon,CouponResponse, CouponSimple, CouponRequest>  implements CouponApi {

    @Resource
    private CouponRepository couponRepository;

    @Override
    public JpaRepositoryImplementation<Coupon, Serializable> getJpaRepository() {
        return couponRepository;
    }

    @Override
    public Function<Coupon, CouponSimple> getConvertSimple() {
        return new CouponSimpleConvert();
    }

    @Override
    public Function<CouponRequest, Coupon> getConvertForm() {
        return new CouponEntityConvert();
    }

    @Override
    public Function<Coupon, CouponResponse> getConvertResponse() {
    return new CouponResponseConvert();
    }




}


