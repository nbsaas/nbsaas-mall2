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

import com.ada.area.entity.Area;
import com.ada.area.page.AreaPage;
import com.ada.area.service.AreaService;
import com.ada.data.core.Pagination;
import com.ada.data.page.Page;

@Controller
@RequestMapping(value = "admin")
public class AreaManagerAction {

	@Autowired
	AreaService areaService;

	Logger logger = LoggerFactory.getLogger("log");
	int aid = 0;

	@RequestMapping(value = "area/list", method = RequestMethod.GET)
	public String list(
			@RequestParam(value = "id", required = true, defaultValue = "1") int id,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		List<Area> rs = areaService.findByParent(id);
		model.addAttribute("list", rs);
		model.addAttribute("tops", areaService.findByTops(id));
		model.addAttribute("id", id);
		model.addAttribute("courseitem", areaService.findById(id));
		model.addAttribute("menus", areaService.findByParent(1));

		return "admin/area/list";
	}

	@RequestMapping(value = "area/circles", method = RequestMethod.GET)
	public String circles(
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		AreaPage rs = areaService.pageByLevel(5, curpage, pagesize);
		model.addAttribute("page", rs);
		model.addAttribute("list", rs.getList());
		model.addAttribute("curpage", curpage);
		model.addAttribute("pagesize", pagesize);
		return "admin/area/circles";
	}

	@RequestMapping(value = "area/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		return "admin/area/index";
	}

	@RequestMapping(value = "area/view_add", method = RequestMethod.GET)
	public String view_add(HttpServletRequest request, Integer pid,
			HttpServletResponse response, Model model) {
		Area item = areaService.findById(pid);
		model.addAttribute("item", item);
		return "admin/area/view_add";
	}

	@RequestMapping(value = "area/circle_add", method = RequestMethod.GET)
	public String circle_add(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		model.addAttribute("areas", areaService.findById(1));
		
		return "admin/area/circle_add";
	}

	@RequestMapping(value = "area/circle_save", method = RequestMethod.POST)
	public String circle_save(Area menu, HttpServletRequest request,
			HttpServletResponse response, Model model) {

		areaService.save(menu);

		return "redirect:/admin/area/circles.htm";
	}
	@RequestMapping(value = "area/circle_update", method = RequestMethod.POST)
	public String circle_update(Area menu, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		areaService.update(menu);

		return "redirect:/admin/area/circles.htm";
	}

	@RequestMapping(value = "area/circle_delte", method ={ RequestMethod.POST,RequestMethod.GET})
	public String circle_delte(int id, HttpServletRequest request,
			HttpServletResponse response, Model model) {

		areaService.deleteById(id);

		return "redirect:/admin/area/circles.htm";
	}

	@RequestMapping(value = "area/model_add", method = RequestMethod.POST)
	public String model_add(Area menu, HttpServletRequest request,
			HttpServletResponse response, Model model) {

		areaService.save(menu);

		return "redirect:/admin/area/list.htm?id=" + menu.getParentId();
	}

	@RequestMapping(value = "area/view_update", method = RequestMethod.GET)
	public String view_update(int id,HttpServletRequest request,
			HttpServletResponse response, Model model) {
		model.addAttribute("area", areaService.findById(id));
		return "admin/area/view_update";
	}

	@RequestMapping(value = "area/model_update", method ={RequestMethod.GET,RequestMethod.POST})
	public String model_update(Area area, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		areaService.update(area);
		return "admin/area/model_update";
	}

	@RequestMapping(value = "area/model_delete", method = RequestMethod.GET)
	public String model_delete(int typeid, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		Area m = areaService.findById(typeid);
		Integer id = m.getParentId();
		areaService.deleteById(typeid);

		return "redirect:/admin/area/list.htm?id=" + id;
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
