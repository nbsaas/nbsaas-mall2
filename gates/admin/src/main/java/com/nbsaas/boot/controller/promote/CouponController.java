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
import com.nbsaas.boot.promote.api.domain.request.CouponRequest;
import com.nbsaas.boot.promote.api.domain.request.CouponSearch;
import com.nbsaas.boot.promote.api.domain.response.CouponResponse;
import com.nbsaas.boot.promote.api.domain.simple.CouponSimple;
import com.nbsaas.boot.promote.api.apis.CouponApi;
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
@RequestMapping("/coupon")
public class CouponController {


    @Resource
    private CouponApi couponApi;


    @RequiresPermissions("coupon")
    @RequestMapping("/search")
    public PageResponse <CouponSimple> search(CouponSearch request) {
        return couponApi.search(request);
    }

    @RequiresPermissions("coupon")
    @RequestMapping("/list")
    public ListResponse<CouponSimple> list(CouponSearch request) {
        return couponApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("coupon")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <CouponResponse> create(@Validated(AddOperator.class) CouponRequest request) {
        return couponApi.create(request);
    }

   @RequiresPermissions("coupon")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<CouponResponse> update(@Validated(UpdateOperator.class) CouponRequest request) {
       return couponApi.update(request);
   }

    @RequiresPermissions("coupon")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) CouponRequest request) {
        return couponApi.delete(request);
    }

    @RequiresPermissions("coupon")
    @RequestMapping("/view")
    public ResponseObject <CouponResponse> view(@Validated(ViewOperator.class) CouponRequest  request) {
        return couponApi.view(request);
    }
}