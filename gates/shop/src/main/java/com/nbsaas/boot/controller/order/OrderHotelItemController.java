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
import com.nbsaas.boot.order.api.domain.request.OrderHotelItemRequest;
import com.nbsaas.boot.order.api.domain.request.OrderHotelItemSearch;
import com.nbsaas.boot.order.api.domain.response.OrderHotelItemResponse;
import com.nbsaas.boot.order.api.domain.simple.OrderHotelItemSimple;
import com.nbsaas.boot.order.api.apis.OrderHotelItemApi;
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
@RequestMapping("/orderHotelItem")
public class OrderHotelItemController {


    @Resource
    private OrderHotelItemApi orderHotelItemApi;


    @RequiresPermissions("orderHotelItem")
    @RequestMapping("/search")
    public PageResponse <OrderHotelItemSimple> search(OrderHotelItemSearch request) {
        return orderHotelItemApi.search(request);
    }

    @RequiresPermissions("orderHotelItem")
    @RequestMapping("/list")
    public ListResponse<OrderHotelItemSimple> list(OrderHotelItemSearch request) {
        return orderHotelItemApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("orderHotelItem")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <OrderHotelItemResponse> create(@Validated(AddOperator.class) OrderHotelItemRequest request) {
        return orderHotelItemApi.create(request);
    }

   @RequiresPermissions("orderHotelItem")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<OrderHotelItemResponse> update(@Validated(UpdateOperator.class) OrderHotelItemRequest request) {
       return orderHotelItemApi.update(request);
   }

    @RequiresPermissions("orderHotelItem")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) OrderHotelItemRequest request) {
        return orderHotelItemApi.delete(request);
    }

    @RequiresPermissions("orderHotelItem")
    @RequestMapping("/view")
    public ResponseObject <OrderHotelItemResponse> view(@Validated(ViewOperator.class) OrderHotelItemRequest  request) {
        return orderHotelItemApi.view(request);
    }
}