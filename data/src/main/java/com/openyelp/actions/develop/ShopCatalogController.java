package com.openyelp.actions.develop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openyelp.data.service.ShopCategoryService;
import com.openyelp.web.utils.FrontUtils;

@Controller
@RequestMapping(value = "develop")
public class ShopCatalogController {

	@Autowired
	ShopCategoryService categoryService;
	
	@RequestMapping(value = "shopcataloglist")
	public String list(Model model){
		model.addAttribute("list", categoryService.findByPidl2(1));
		return FrontUtils.getPath("develop/shopcataloglist");
	}
}
