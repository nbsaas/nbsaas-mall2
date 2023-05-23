package com.nbsaas.life.controller.system;

import com.nbsaas.boot.rest.annotations.AddOperator;
import com.nbsaas.boot.rest.annotations.DeleteOperator;
import com.nbsaas.boot.rest.annotations.UpdateOperator;
import com.nbsaas.boot.rest.annotations.ViewOperator;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.rest.annotations.CreateData;
import com.nbsaas.boot.rest.annotations.UpdateData;
import com.nbsaas.life.system.api.domain.request.MenuDataRequest;
import com.nbsaas.life.system.api.domain.request.MenuSearchRequest;
import com.nbsaas.life.system.api.domain.response.MenuResponse;
import com.nbsaas.life.system.api.domain.simple.MenuSimple;
import com.nbsaas.life.system.api.apis.MenuApi;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
*  前端控制器
*/
@RequiresAuthentication
@RestController
@RequestMapping("/menu")
public class MenuFrontController {


    @Resource
    private MenuApi menuApi;


    @RequestMapping("/search")
   public PageResponse<MenuSimple> search(MenuSearchRequest request) {
        return menuApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse <MenuSimple> list(MenuSearchRequest request) {
        return menuApi.list(request);
    }

        /**
        * 添加数据
        *
        * @param request
        * @return
        */
    @CreateData
  @RequestMapping("/create")
   public ResponseObject<MenuResponse> create(@Validated(AddOperator.class) MenuDataRequest request) {
       return menuApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
   public ResponseObject
    <MenuResponse> update(@Validated(UpdateOperator.class) MenuDataRequest request) {
         return menuApi.update(request);
    }

     @RequestMapping("/delete")
     public ResponseObject<?> delete(@Validated(DeleteOperator.class) MenuDataRequest request) {
        return menuApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject <MenuResponse> view(@Validated(ViewOperator.class) MenuDataRequest request) {
         return menuApi.view(request);
    }
}
