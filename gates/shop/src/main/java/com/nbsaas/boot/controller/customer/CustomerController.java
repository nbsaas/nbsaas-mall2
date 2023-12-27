package com.nbsaas.boot.controller.customer;

import com.nbsaas.boot.rest.annotations.AddOperator;
import com.nbsaas.boot.rest.annotations.DeleteOperator;
import com.nbsaas.boot.rest.annotations.UpdateOperator;
import com.nbsaas.boot.rest.annotations.ViewOperator;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.rest.annotations.CreateData;
import com.nbsaas.boot.rest.annotations.UpdateData;
import com.nbsaas.boot.customer.api.domain.request.CustomerRequest;
import com.nbsaas.boot.customer.api.domain.request.CustomerSearch;
import com.nbsaas.boot.customer.api.domain.response.CustomerResponse;
import com.nbsaas.boot.customer.api.domain.simple.CustomerSimple;
import com.nbsaas.boot.customer.api.apis.CustomerApi;
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
@RequestMapping("/customer")
public class CustomerController {


    @Resource
    private CustomerApi customerApi;


    @RequiresPermissions("customer")
    @RequestMapping("/search")
    public PageResponse <CustomerSimple> search(CustomerSearch request) {
        return customerApi.search(request);
    }

    @RequiresPermissions("customer")
    @RequestMapping("/list")
    public ListResponse<CustomerSimple> list(CustomerSearch request) {
        return customerApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("customer")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <CustomerResponse> create(@Validated(AddOperator.class) CustomerRequest request) {
        return customerApi.create(request);
    }

   @RequiresPermissions("customer")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<CustomerResponse> update(@Validated(UpdateOperator.class) CustomerRequest request) {
       return customerApi.update(request);
   }

    @RequiresPermissions("customer")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) CustomerRequest request) {
        return customerApi.delete(request);
    }

    @RequiresPermissions("customer")
    @RequestMapping("/view")
    public ResponseObject <CustomerResponse> view(@Validated(ViewOperator.class) CustomerRequest  request) {
        return customerApi.view(request);
    }
}