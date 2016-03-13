package com.openyelp.actions.admin;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Order.Direction;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import com.openyelp.data.entity.EventInfoCategory;
import com.openyelp.data.service.EventInfoCategoryService;

@Controller
public class EventInfoCategoryAction {
	private static final Logger log = LoggerFactory.getLogger(EventInfoCategoryAction.class);

	@RequestMapping("/admin/eventinfocategory/view_list")
	public String list(@RequestParam(value = "id", required = true, defaultValue = "1") int id, Pageable pageable,
			HttpServletRequest request, ModelMap model) {

		if (pageable == null) {
			pageable = new Pageable();
		}
		pageable.getFilters().add(Filter.eq("parent.id", id));
		pageable.setOrderProperty("sortnum");
		pageable.setOrderDirection(Direction.asc);
		if (pageable.getOrders() == null || pageable.getOrders().size() == 0) {
			pageable.getOrders().add(Order.desc("id"));
		}
		Page<EventInfoCategory> pagination = manager.findPage(pageable);
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		model.addAttribute("id", id);
		return "admin/eventinfocategory/list";
	}

	@RequestMapping("/admin/eventinfocategory/view_add")
	public String add(ModelMap model) {
		return "admin/eventinfocategory/add";
	}

	@RequestMapping("/admin/eventinfocategory/view_edit")
	public String edit(Integer id, Integer pageNo, HttpServletRequest request, ModelMap model) {
		model.addAttribute("model", manager.findById(id));
		model.addAttribute("pageNo", pageNo);
		return "admin/eventinfocategory/edit";
	}

	@RequestMapping("/admin/eventinfocategory/model_save")
	public String save(EventInfoCategory bean, HttpServletRequest request, ModelMap model) {
		bean = manager.save(bean);
		log.info("save Teacher id={}", bean.getId());
		return "redirect:view_list.htm";
	}

	@RequestMapping("/admin/eventinfocategory/model_update")
	public String update(Pageable pageable, EventInfoCategory bean, HttpServletRequest request, ModelMap model) {
		bean = manager.update(bean);
		log.info("update Teacher id={}.", bean.getId());
		return "redirect:/admin/eventinfocategory/view_list.htm?pageNumber="+pageable.getPageNumber();
	}

	@RequestMapping("/admin/eventinfocategory/model_delete")
	public String delete(Pageable pageable, Integer id, HttpServletRequest request, ModelMap model) {

		manager.deleteById(id);

		return "redirect:/admin/eventinfocategory/view_list.htm?pageNumber="+pageable.getPageNumber();
	}

	@RequestMapping("/admin/eventinfocategory/model_deletes")
	public String deletes(Pageable pageable, Integer[] ids, HttpServletRequest request, ModelMap model) {

		manager.deleteByIds(ids);

		return "redirect:/admin/eventinfocategory/view_list.htm?pageNumber="+pageable.getPageNumber();
	}

	@Autowired
	private EventInfoCategoryService manager;
}