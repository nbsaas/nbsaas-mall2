package com.quhaodian.haodian.actions.develop;

import com.quhaodian.web.controller.front.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quhaodian.haodian.data.service.ShopCategoryService;
import com.quhaodian.haodian.web.utils.FrontUtils;

@Controller
@RequestMapping(value = "develop")
public class ShopCatalogController extends BaseController{

	@Autowired
	ShopCategoryService categoryService;
	
	@RequestMapping(value = "shopcataloglist")
	public String list(Model model){
		model.addAttribute("list", categoryService.findByPidl2(1));
		return getView("develop/shopcataloglist");
	}
}
