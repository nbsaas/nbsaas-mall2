package com.quhaodian.haodian.actions.admin;



import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import com.quhaodian.haodian.data.entity.ShopCategory;
import com.quhaodian.haodian.data.service.ShopCategoryService;
@Controller
public class ShopCategoryAction {
	private static final Logger log = LoggerFactory.getLogger(ShopCategoryAction.class);

	@RequestMapping("/admin/shopcategory/view_list")
	public String list(@RequestParam(value = "id", required = true, defaultValue = "1") int id,Pageable pageable, HttpServletRequest request, ModelMap model) {
	
		if (pageable==null) {
			pageable=new Pageable();
		}
		pageable.getFilters().add(Filter.eq("parent.id", id));
		// pageable.setOrderProperty("sortnum");
		// pageable.setOrderDirection(Direction.asc);
		if (pageable.getOrders() == null || pageable.getOrders().size() == 0) {
			pageable.getOrders().add(Order.desc("id"));
		}
		Page<ShopCategory> pagination = manager.findPage(pageable);
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("tops", manager.findTop(id));

		model.addAttribute("page", pagination);
		model.addAttribute("id", id);
		return "admin/shopcategory/list";
	}

	@RequestMapping("/admin/shopcategory/view_add")
	public String add(ModelMap model) {
		return "admin/shopcategory/add";
	}

	@RequestMapping("/admin/shopcategory/view_edit")
	public String edit(Pageable pageable,Integer id,Integer pid, Integer pageNo, HttpServletRequest request, ModelMap model) {
		model.addAttribute("model", manager.findById(id));
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("page", pageable);
		model.addAttribute("pid", pid);
		return "admin/shopcategory/edit";
	}

	@RequestMapping("/admin/shopcategory/model_save")
	public String save(ShopCategory bean,Integer pid, HttpServletRequest request, ModelMap model) {
		bean = manager.save(bean);
		log.info("save Teacher id={}", bean.getId());
		return "redirect:/admin/shopcategory/view_list.htm?id="+pid;
	}

	@RequestMapping("/admin/shopcategory/model_update")
	public String update(Pageable pageable,Integer pid, ShopCategory bean,HttpServletRequest request, ModelMap model) {
		bean = manager.update(bean);
		log.info("update Teacher id={}.", bean.getId());
		return "redirect:/admin/shopcategory/view_list.htm?pageNumber="+pageable.getPageNumber()+"&id="+pid;
	}

	@RequestMapping("/admin/shopcategory/model_delete")
	public String delete(Pageable pageable,Integer pid, Integer id, HttpServletRequest request, ModelMap model) {
			 
				manager.deleteById(id);
			 
		return "redirect:/admin/shopcategory/view_list.htm?pageNumber="+pageable.getPageNumber()+"&id="+pid;
	}
	@RequestMapping("/admin/shopcategory/model_deletes")
	public String deletes(Pageable pageable, Integer[] ids, HttpServletRequest request, ModelMap model) {
			 
				manager.deleteByIds(ids);
			 
		return "redirect:/admin/shopcategory/view_list.htm?pageNumber="+pageable.getPageNumber();
	}
	@Autowired
	private ShopCategoryService manager;
}