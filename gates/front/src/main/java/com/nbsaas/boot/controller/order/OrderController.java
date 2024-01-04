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
import com.nbsaas.boot.order.api.domain.request.OrderRequest;
import com.nbsaas.boot.order.api.domain.request.OrderSearch;
import com.nbsaas.boot.order.api.domain.response.OrderResponse;
import com.nbsaas.boot.order.api.domain.simple.OrderSimple;
import com.nbsaas.boot.order.api.apis.OrderApi;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
*  对外控制器
*/
//@RequiresAuthentication
@RestController
@RequestMapping("/order")
public class OrderController {


    @Resource
    private OrderApi orderApi;


//    @RequiresPermissions("order")
    @RequestMapping("/search")
    public PageResponse <OrderSimple> search(OrderSearch request) {
        return orderApi.search(request);
    }

    @RequiresPermissions("order")
    @RequestMapping("/list")
    public ListResponse<OrderSimple> list(OrderSearch request) {
        return orderApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
//    @RequiresPermissions("order")
   // @CreateData
    @RequestMapping("/create")
    public ResponseObject <OrderResponse> create(OrderRequest request) {
        return orderApi.create(request);
    }

   @RequiresPermissions("order")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<OrderResponse> update(@Validated(UpdateOperator.class) OrderRequest request) {
       return orderApi.update(request);
   }

    @RequiresPermissions("order")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) OrderRequest request) {
        return orderApi.delete(request);
    }

    @RequiresPermissions("order")
    @RequestMapping("/view")
    public ResponseObject <OrderResponse> view(@Validated(ViewOperator.class) OrderRequest  request) {
        return orderApi.view(request);
    }
}