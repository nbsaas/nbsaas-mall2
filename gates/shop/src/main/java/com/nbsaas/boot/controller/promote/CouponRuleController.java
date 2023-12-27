package com.nbsaas.boot.controller.promote;

import com.nbsaas.boot.rest.annotations.AddOperator;
import com.nbsaas.boot.rest.annotations.DeleteOperator;
import com.nbsaas.boot.rest.annotations.UpdateOperator;
import com.nbsaas.boot.rest.annotations.ViewOperator;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.rest.annotations.CreateData;
import com.nbsaas.boot.rest.annotations.UpdateData;
import com.nbsaas.boot.promote.api.domain.request.CouponRuleRequest;
import com.nbsaas.boot.promote.api.domain.request.CouponRuleSearch;
import com.nbsaas.boot.promote.api.domain.response.CouponRuleResponse;
import com.nbsaas.boot.promote.api.domain.simple.CouponRuleSimple;
import com.nbsaas.boot.promote.api.apis.CouponRuleApi;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
*  对外控制器
*/
@RequiresAuthentication
@RestController
@RequestMapping("/couponRule")
public class CouponRuleController {


    @Resource
    private CouponRuleApi couponRuleApi;


    @RequiresPermissions("couponRule")
    @RequestMapping("/search")
    public PageResponse <CouponRuleSimple> search(CouponRuleSearch request) {
        return couponRuleApi.search(request);
    }

    @RequiresPermissions("couponRule")
    @RequestMapping("/list")
    public ListResponse<CouponRuleSimple> list(CouponRuleSearch request) {
        return couponRuleApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("couponRule")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <CouponRuleResponse> create(@Validated(AddOperator.class) CouponRuleRequest request) {
        return couponRuleApi.create(request);
    }

   @RequiresPermissions("couponRule")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<CouponRuleResponse> update(@Validated(UpdateOperator.class) CouponRuleRequest request) {
       return couponRuleApi.update(request);
   }

    @RequiresPermissions("couponRule")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) CouponRuleRequest request) {
        return couponRuleApi.delete(request);
    }

    @RequiresPermissions("couponRule")
    @RequestMapping("/view")
    public ResponseObject <CouponRuleResponse> view(@Validated(ViewOperator.class) CouponRuleRequest  request) {
        return couponRuleApi.view(request);
    }
}