package com.haoxuer.haodian.actions.rest;

import com.haoxuer.haodian.api.CategoryApi;
import com.haoxuer.haodian.data.entity.ShopCategory;
import com.haoxuer.haodian.data.service.ShopCategoryService;
import com.haoxuer.haodian.data.shop.vo.ShopCatalog;
import com.haoxuer.haodian.domain.list.CategoryList;
import com.haoxuer.haodian.domain.request.CategoryFindByPidRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "shopcatalog")
public class ShopCatalogRestController {
  
  @Autowired
  ShopCategoryService areaService;
  
  @Autowired
  private CategoryApi api;
  
  @RequestMapping(value = "findbypid", method = RequestMethod.GET)
  public CategoryList findByPid(CategoryFindByPidRequest request) {
    return api.findByPid(request);
  }
  

  
  @RequestMapping(value = "querybylist", method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public List<ShopCategory> findByArea(@RequestParam(value = "id", required = true, defaultValue = "1") int id) {
    List<ShopCategory> result = areaService.findByPid(id);
    return result;
  }
  
  @RequestMapping(value = "querybylevel", method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public List<ShopCatalog> findBylvel(@RequestParam(value = "id", required = true, defaultValue = "1") int id) {
    List<ShopCatalog> result = areaService.findByPidl2(id);
    return result;
  }
  
}
