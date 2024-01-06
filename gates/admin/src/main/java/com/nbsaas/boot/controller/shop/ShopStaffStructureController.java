package com.nbsaas.boot.controller.shop;

import com.nbsaas.boot.rest.annotations.AddOperator;
import com.nbsaas.boot.rest.annotations.DeleteOperator;
import com.nbsaas.boot.rest.annotations.UpdateOperator;
import com.nbsaas.boot.rest.annotations.ViewOperator;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.rest.annotations.CreateData;
import com.nbsaas.boot.rest.annotations.UpdateData;
import com.nbsaas.boot.shop.api.domain.request.ShopStaffStructureRequest;
import com.nbsaas.boot.shop.api.domain.request.ShopStaffStructureSearch;
import com.nbsaas.boot.shop.api.domain.response.ShopStaffStructureResponse;
import com.nbsaas.boot.shop.api.domain.simple.ShopStaffStructureSimple;
import com.nbsaas.boot.shop.api.apis.ShopStaffStructureApi;
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
@RequestMapping("/shopStaffStructure")
public class ShopStaffStructureController {


    @Resource
    private ShopStaffStructureApi shopStaffStructureApi;


    @RequiresPermissions("shopStaffStructure")
    @RequestMapping("/search")
    public PageResponse <ShopStaffStructureSimple> search(ShopStaffStructureSearch request) {
        return shopStaffStructureApi.search(request);
    }

    @RequiresPermissions("shopStaffStructure")
    @RequestMapping("/list")
    public ListResponse<ShopStaffStructureSimple> list(ShopStaffStructureSearch request) {
        return shopStaffStructureApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("shopStaffStructure")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <ShopStaffStructureResponse> create(@Validated(AddOperator.class) ShopStaffStructureRequest request) {
        return shopStaffStructureApi.create(request);
    }

   @RequiresPermissions("shopStaffStructure")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<ShopStaffStructureResponse> update(@Validated(UpdateOperator.class) ShopStaffStructureRequest request) {
       return shopStaffStructureApi.update(request);
   }

    @RequiresPermissions("shopStaffStructure")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) ShopStaffStructureRequest request) {
        return shopStaffStructureApi.delete(request);
    }

    @RequiresPermissions("shopStaffStructure")
    @RequestMapping("/view")
    public ResponseObject <ShopStaffStructureResponse> view(@Validated(ViewOperator.class) ShopStaffStructureRequest  request) {
        return shopStaffStructureApi.view(request);
    }
}