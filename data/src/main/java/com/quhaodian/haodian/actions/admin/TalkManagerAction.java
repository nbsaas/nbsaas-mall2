package com.quhaodian.haodian.actions.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quhaodian.haodian.data.entity.Talk;
import com.quhaodian.haodian.data.service.TalkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quhaodian.data.core.Pagination;


@Controller
@RequestMapping(value = "admin")
public class TalkManagerAction {

	
	@Autowired
    TalkService menuService;

	Logger logger = LoggerFactory.getLogger("log");
	int aid = 0;

	@RequestMapping(value = "talk/list", method = RequestMethod.GET)
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

		return "admin/talk/list";
	}

	@RequestMapping(value = "talk/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		return "admin/talk/index";
	}

	@RequestMapping(value = "talk/view_add", method = RequestMethod.GET)
	public String view_add(HttpServletRequest request, Long pid,
			HttpServletResponse response, Model model) {
		Talk item = menuService.findById(pid);
		model.addAttribute("item", item);
		return "admin/talk/view_add";
	}

	@RequestMapping(value = "talk/model_add", method = RequestMethod.POST)
	public String model_add(Talk menu, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		
		menuService.save(menu);
		
		return "redirect:/admin/talk/list.htm?id="+menu.getId();
	}

	@RequestMapping(value = "talk/view_update", method = RequestMethod.GET)
	public String view_update(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		return "admin/talk/view_update";
	}

	@RequestMapping(value = "talk/model_update", method = RequestMethod.GET)
	public String model_update(Talk menu,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		menuService.update(menu);

		return "admin/talk/model_update";
	}

	@RequestMapping(value = "talk/model_delete", method = RequestMethod.GET)
	public String model_delete(Long id,@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		menuService.deleteById(id);

		return "redirect:/admin/talk/list.htm?curpage="+curpage;
	}
}
