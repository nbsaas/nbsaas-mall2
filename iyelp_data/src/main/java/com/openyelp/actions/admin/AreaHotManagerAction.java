package com.openyelp.actions.admin;

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

import com.openyelp.data.core.Pagination;
import com.openyelp.data.entity.AreaHot;
import com.openyelp.data.service.AreaHotService;


@Controller
@RequestMapping(value = "admin")
public class AreaHotManagerAction {

	
	@Autowired
	AreaHotService menuService;

	Logger logger = LoggerFactory.getLogger("log");
	int aid = 0;

	@RequestMapping(value = "areahot/list", method = RequestMethod.GET)
	public String list(
			@RequestParam(value = "id", required = true, defaultValue = "1") int id,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		Pagination rs = menuService.page(curpage, pagesize);

		model.addAttribute("list", rs.getList());
		model.addAttribute("page", rs);
		model.addAttribute("curpage", rs.getPageNo());
		model.addAttribute("pagesize", rs.getPageSize());

		return "admin/areahot/list";
	}

	@RequestMapping(value = "areahot/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		return "admin/areahot/index";
	}

	@RequestMapping(value = "areahot/view_add", method = RequestMethod.GET)
	public String view_add(HttpServletRequest request, 
			HttpServletResponse response, Model model) {
		return "admin/areahot/view_add";
	}

	@RequestMapping(value = "areahot/model_add", method = RequestMethod.POST)
	public String model_add(AreaHot menu, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		
		menuService.save(menu);
		
		return "redirect:/admin/areahot/list.htm";
	}

	@RequestMapping(value = "areahot/view_update", method = RequestMethod.GET)
	public String view_update(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		return "admin/areahot/view_update";
	}

	@RequestMapping(value = "areahot/model_update", method = RequestMethod.GET)
	public String model_update(AreaHot menu,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		menuService.update(menu);

		return "admin/areahot/model_update";
	}

	@RequestMapping(value = "areahot/model_delete", method = RequestMethod.GET)
	public String model_delete(int id, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		menuService.deleteById(id);

		return "redirect:/admin/areahot/list.htm?id="+id;
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
