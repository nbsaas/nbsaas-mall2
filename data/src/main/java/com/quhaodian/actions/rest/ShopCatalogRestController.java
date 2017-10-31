package com.quhaodian.actions.rest;

import java.util.List;

import com.quhaodian.data.entity.ShopCategory;
import com.quhaodian.data.service.ShopCategoryService;
import com.quhaodian.data.shop.vo.ShopCatalog;
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
	
	@RequestMapping(value = "querybylist", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)  
	public List<ShopCategory> findByArea(@RequestParam(value = "id", required = true, defaultValue = "1") int id){
		List<ShopCategory> result=areaService.findByPid(id);
		return result;
	}
	
	@RequestMapping(value = "querybylevel", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)  
	public List<ShopCatalog> findBylvel(@RequestParam(value = "id", required = true, defaultValue = "1") int id){
		List<ShopCatalog> result=areaService.findByPidl2(id);
		return result;
	}

}
