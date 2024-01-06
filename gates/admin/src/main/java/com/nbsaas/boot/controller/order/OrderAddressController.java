package com.nbsaas.boot.controller.order;

import com.nbsaas.boot.rest.annotations.AddOperator;
import com.nbsaas.boot.rest.annotations.DeleteOperator;
import com.nbsaas.boot.rest.annotations.UpdateOperator;
import com.nbsaas.boot.rest.annotations.ViewOperator;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.rest.annotations.CreateData;
import com.nbsaas.boot.rest.annotations.UpdateData;
import com.nbsaas.boot.order.api.domain.request.OrderAddressRequest;
import com.nbsaas.boot.order.api.domain.request.OrderAddressSearch;
import com.nbsaas.boot.order.api.domain.response.OrderAddressResponse;
import com.nbsaas.boot.order.api.domain.simple.OrderAddressSimple;
import com.nbsaas.boot.order.api.apis.OrderAddressApi;
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
@RequestMapping("/orderAddress")
public class OrderAddressController {


    @Resource
    private OrderAddressApi orderAddressApi;


    @RequiresPermissions("orderAddress")
    @RequestMapping("/search")
    public PageResponse <OrderAddressSimple> search(OrderAddressSearch request) {
        return orderAddressApi.search(request);
    }

    @RequiresPermissions("orderAddress")
    @RequestMapping("/list")
    public ListResponse<OrderAddressSimple> list(OrderAddressSearch request) {
        return orderAddressApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("orderAddress")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <OrderAddressResponse> create(@Validated(AddOperator.class) OrderAddressRequest request) {
        return orderAddressApi.create(request);
    }

   @RequiresPermissions("orderAddress")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<OrderAddressResponse> update(@Validated(UpdateOperator.class) OrderAddressRequest request) {
       return orderAddressApi.update(request);
   }

    @RequiresPermissions("orderAddress")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) OrderAddressRequest request) {
        return orderAddressApi.delete(request);
    }

    @RequiresPermissions("orderAddress")
    @RequestMapping("/view")
    public ResponseObject <OrderAddressResponse> view(@Validated(ViewOperator.class) OrderAddressRequest  request) {
        return orderAddressApi.view(request);
    }
}