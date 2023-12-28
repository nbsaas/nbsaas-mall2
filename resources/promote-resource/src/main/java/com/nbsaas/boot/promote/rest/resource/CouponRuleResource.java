package com.nbsaas.boot.promote.rest.resource;

import com.nbsaas.boot.promote.api.apis.CouponRuleApi;
import com.nbsaas.boot.promote.data.entity.CouponRule;
import com.nbsaas.boot.promote.api.domain.request.CouponRuleRequest;
import com.nbsaas.boot.promote.api.domain.response.CouponRuleResponse;
import com.nbsaas.boot.promote.api.domain.simple.CouponRuleSimple;
import com.nbsaas.boot.promote.rest.convert.CouponRuleSimpleConvert;
import com.nbsaas.boot.promote.rest.convert.CouponRuleEntityConvert;
import com.nbsaas.boot.promote.rest.convert.CouponRuleResponseConvert;
import com.nbsaas.boot.promote.data.repository.CouponRuleRepository;

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
public class CouponRuleResource extends BaseResource<CouponRule,CouponRuleResponse, CouponRuleSimple, CouponRuleRequest>  implements CouponRuleApi {

    @Resource
    private CouponRuleRepository couponRuleRepository;

    @Override
    public JpaRepositoryImplementation<CouponRule, Serializable> getJpaRepository() {
        return couponRuleRepository;
    }

    @Override
    public Function<CouponRule, CouponRuleSimple> getConvertSimple() {
        return new CouponRuleSimpleConvert();
    }

    @Override
    public Function<CouponRuleRequest, CouponRule> getConvertForm() {
        return new CouponRuleEntityConvert();
    }

    @Override
    public Function<CouponRule, CouponRuleResponse> getConvertResponse() {
        return new CouponRuleResponseConvert();
    }




}


