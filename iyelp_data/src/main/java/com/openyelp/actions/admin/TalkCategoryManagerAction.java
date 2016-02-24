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

import com.openyelp.data.entity.TalkCategory;
import com.openyelp.data.service.TalkCategoryService;


@Controller
@RequestMapping(value = "admin")
public class TalkCategoryManagerAction {

	
	@Autowired
	TalkCategoryService menuService;

	Logger logger = LoggerFactory.getLogger("log");
	int aid = 0;

	@RequestMapping(value = "talkcategory/list", method = RequestMethod.GET)
	public String list(
			@RequestParam(value = "id", required = true, defaultValue = "1") int id,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		List<TalkCategory> rs = menuService.findByPid(id);

		model.addAttribute("list", rs);
		model.addAttribute("id", id);
		model.addAttribute("courseitem", menuService.findById(id));
		model.addAttribute("menus",menuService.findByPid(1));

		return "admin/talkcategory/list";
	}

	@RequestMapping(value = "talkcategory/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		return "admin/talkcategory/index";
	}

	@RequestMapping(value = "talkcategory/view_add", method = RequestMethod.GET)
	public String view_add(HttpServletRequest request, int pid,
			HttpServletResponse response, Model model) {
		TalkCategory item = menuService.findById(pid);
		model.addAttribute("item", item);
		return "admin/talkcategory/view_add";
	}

	@RequestMapping(value = "talkcategory/model_add", method = RequestMethod.POST)
	public String model_add(TalkCategory menu, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		
		menuService.save(menu);
		
		return "redirect:/admin/talkcategory/list.htm?id="+menu.getParentId();
	}

	@RequestMapping(value = "talkcategory/view_update", method = RequestMethod.GET)
	public String view_update(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		return "admin/talkcategory/view_update";
	}

	@RequestMapping(value = "talkcategory/model_update", method = RequestMethod.GET)
	public String model_update(TalkCategory menu,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		menuService.update(menu);

		return "admin/talkcategory/model_update";
	}

	@RequestMapping(value = "talkcategory/model_delete", method = RequestMethod.GET)
	public String model_delete(int typeid, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		TalkCategory m=	menuService.findById(typeid);
		Integer id=m.getParentId();
		menuService.deleteById(typeid);

		return "redirect:/admin/talkcategory/list.htm?id="+id;
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
