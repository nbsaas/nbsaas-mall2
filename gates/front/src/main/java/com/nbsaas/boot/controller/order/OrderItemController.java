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
import com.nbsaas.boot.order.api.domain.request.OrderItemRequest;
import com.nbsaas.boot.order.api.domain.request.OrderItemSearch;
import com.nbsaas.boot.order.api.domain.response.OrderItemResponse;
import com.nbsaas.boot.order.api.domain.simple.OrderItemSimple;
import com.nbsaas.boot.order.api.apis.OrderItemApi;
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
@RequestMapping("/orderItem")
public class OrderItemController {


    @Resource
    private OrderItemApi orderItemApi;


    @RequiresPermissions("orderItem")
    @RequestMapping("/search")
    public PageResponse <OrderItemSimple> search(OrderItemSearch request) {
        return orderItemApi.search(request);
    }

    @RequiresPermissions("orderItem")
    @RequestMapping("/list")
    public ListResponse<OrderItemSimple> list(OrderItemSearch request) {
        return orderItemApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("orderItem")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <OrderItemResponse> create(@Validated(AddOperator.class) OrderItemRequest request) {
        return orderItemApi.create(request);
    }

   @RequiresPermissions("orderItem")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<OrderItemResponse> update(@Validated(UpdateOperator.class) OrderItemRequest request) {
       return orderItemApi.update(request);
   }

    @RequiresPermissions("orderItem")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) OrderItemRequest request) {
        return orderItemApi.delete(request);
    }

    @RequiresPermissions("orderItem")
    @RequestMapping("/view")
    public ResponseObject <OrderItemResponse> view(@Validated(ViewOperator.class) OrderItemRequest  request) {
        return orderItemApi.view(request);
    }
}