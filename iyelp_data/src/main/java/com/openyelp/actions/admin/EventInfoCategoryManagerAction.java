package com.openyelp.actions.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.openyelp.data.entity.EventInfoCategory;
import com.openyelp.data.service.EventInfoCategoryService;

@Controller
@RequestMapping(value = "admin")
public class EventInfoCategoryManagerAction {

	@Autowired
	EventInfoCategoryService categoryService;

	Logger logger = LoggerFactory.getLogger("log");
	int aid = 0;

	@RequestMapping(value = "eventinfocategory/list", method = RequestMethod.GET)
	public String list(@RequestParam(value = "id", required = true, defaultValue = "1") int id,
			HttpServletRequest request, HttpServletResponse response, Model model) {

		List<EventInfoCategory> rs = categoryService.findByPid(id);

		model.addAttribute("list", rs);
		model.addAttribute("id", id);
		model.addAttribute("courseitem", categoryService.findById(id));
		model.addAttribute("menus", categoryService.findByPid(1));

		return "admin/eventinfocategory/list";
	}

	@RequestMapping(value = "eventinfocategory/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "admin/eventinfocategory/index";
	}

	@RequestMapping(value = "eventinfocategory/view_add", method = RequestMethod.GET)
	public String view_add(HttpServletRequest request, int pid, HttpServletResponse response, Model model) {
		EventInfoCategory item = categoryService.findById(pid);
		model.addAttribute("item", item);
		return "admin/eventinfocategory/view_add";
	}

	@RequestMapping(value = "eventinfocategory/model_add", method = RequestMethod.POST)
	public String model_add(EventInfoCategory menu, HttpServletRequest request, HttpServletResponse response,
			Model model) {

		categoryService.save(menu);

		return "redirect:/admin/eventinfocategory/list.htm?id=" + menu.getParentId();
	}

	@RequestMapping(value = "eventinfocategory/view_update", method = RequestMethod.GET)
	public String view_update(Integer id,HttpServletRequest request,
			HttpServletResponse response, Model model) {
		model.addAttribute("model", categoryService.findById(id));
		return "admin/eventinfocategory/view_update";
	}

	@RequestMapping(value = "eventinfocategory/model_update", method = RequestMethod.GET)
	public String model_update(EventInfoCategory menu, HttpServletRequest request, HttpServletResponse response,
			Model model) {

		menu = categoryService.update(menu);

		return "redirect:/admin/eventinfocategory/list.htm?id=" + menu.getParentId();
	}

	@RequestMapping(value = "eventinfocategory/model_delete", method = RequestMethod.GET)
	public String model_delete(int typeid, HttpServletRequest request, HttpServletResponse response, Model model) {
		EventInfoCategory m = categoryService.findById(typeid);
		Integer id = m.getParentId();
		categoryService.deleteById(typeid);

		return "redirect:/admin/eventinfocategory/list.htm?id=" + id;
	}

	private HttpSession getSession(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			logger.info("会话不存在");
			session = request.getSession(true);
		}
		return session;
	}

}
