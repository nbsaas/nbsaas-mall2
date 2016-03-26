package com.openyelp.actions.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ada.data.core.Pagination;
import com.openyelp.data.service.ShopReviewService;


@Controller
@RequestMapping(value = "admin/shopreview")
public class ShopReviewMgn {

	@Autowired
	ShopReviewService shopReviewService;
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(
			@RequestParam(value = "id", required = true, defaultValue = "1") int id,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "20") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		Pagination rs = shopReviewService.page(curpage, pagesize);

		model.addAttribute("list", rs.getList());
		model.addAttribute("id", id);
		model.addAttribute("page", rs);
		model.addAttribute("curpage", curpage);
		model.addAttribute("pagesize", pagesize);

		return "admin/shopreview/list";
	}
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(
			@RequestParam(value = "id", required = true, defaultValue = "1") long id,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "20") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		shopReviewService.deleteById(id);
		return "redirect:/admin/shopreview/list.htm";
	}
}
