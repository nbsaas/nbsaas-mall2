package com.quhaodian.haodian.actions.admin;

import javax.servlet.http.HttpServletRequest;

import com.quhaodian.haodian.data.entity.TalkCategory;
import com.quhaodian.haodian.data.service.TalkCategoryService;
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

@Controller
public class TalkCategoryAction {
	private static final Logger log = LoggerFactory.getLogger(TalkCategoryAction.class);

	@RequestMapping("/admin/talkcategory/view_list")
	public String list(@RequestParam(value = "id", required = true, defaultValue = "1") int id, Pageable pageable,
			HttpServletRequest request, ModelMap model) {

		if (pageable == null) {
			pageable = new Pageable();
		}
		pageable.getFilters().add(Filter.eq("parent.id", id));
		// pageable.setOrderProperty("sortnum");
		// pageable.setOrderDirection(Direction.asc);
		if (pageable.getOrders() == null || pageable.getOrders().size() == 0) {
			pageable.getOrders().add(Order.desc("id"));
		}
		Page<TalkCategory> pagination = manager.findPage(pageable);
		model.addAttribute("list", pagination.getContent());
		model.addAttribute("page", pagination);
		return "admin/talkcategory/list";
	}

	@RequestMapping("/admin/talkcategory/view_add")
	public String add(ModelMap model) {
		return "admin/talkcategory/add";
	}

	@RequestMapping("/admin/talkcategory/view_edit")
	public String edit(Pageable pageable, Integer id, Integer pageNo, HttpServletRequest request, ModelMap model) {
		model.addAttribute("model", manager.findById(id));
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("page", pageable);
		return "admin/talkcategory/edit";
	}

	@RequestMapping("/admin/talkcategory/model_save")
	public String save(TalkCategory bean, HttpServletRequest request, ModelMap model) {
		bean = manager.save(bean);
		log.info("save Teacher id={}", bean.getId());
		return "redirect:view_list.htm";
	}

	@RequestMapping("/admin/talkcategory/model_update")
	public String update(Pageable pageable, TalkCategory bean, HttpServletRequest request, ModelMap model) {
		bean = manager.update(bean);
		log.info("update Teacher id={}.", bean.getId());
		return "redirect:/admin/talkcategory/view_list.htm?pageNumber=" + pageable.getPageNumber();
	}

	@RequestMapping("/admin/talkcategory/model_delete")
	public String delete(Pageable pageable, Integer id, HttpServletRequest request, ModelMap model) {

		manager.deleteById(id);

		return "redirect:/admin/talkcategory/view_list.htm?pageNumber=" + pageable.getPageNumber();
	}

	@RequestMapping("/admin/talkcategory/model_deletes")
	public String deletes(Pageable pageable, Integer[] ids, HttpServletRequest request, ModelMap model) {

		manager.deleteByIds(ids);

		return "redirect:/admin/talkcategory/view_list.htm?pageNumber=" + pageable.getPageNumber();
	}

	@Autowired
	private TalkCategoryService manager;
}