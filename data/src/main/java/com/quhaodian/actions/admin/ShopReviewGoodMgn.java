package com.quhaodian.actions.admin;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ada.data.core.Pagination;
import com.quhaodian.data.entity.ShopReview;
import com.quhaodian.data.entity.ShopReviewGood;
import com.quhaodian.data.service.ShopReviewGoodService;
import com.quhaodian.shiro.utils.UserUtil;

@Controller
@RequestMapping(value = "admin")
public class ShopReviewGoodMgn {

	@Autowired
	ShopReviewGoodService shopReviewGoodService;

	@RequestMapping(value = "shopreviewgood/list", method = RequestMethod.GET)
	public String list(
			@RequestParam(value = "id", required = true, defaultValue = "1") int id,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "20") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		Pagination rs = shopReviewGoodService.getPage(curpage, pagesize);

		model.addAttribute("list", rs.getList());
		model.addAttribute("id", id);
		model.addAttribute("page", rs);
		model.addAttribute("curpage", curpage);
		model.addAttribute("pagesize", pagesize);

		return "admin/shopreviewgood/list";
	}
	
	@RequestMapping(value = "shopreviewgood/add", method = RequestMethod.GET)
	public String add(
			@RequestParam(value = "id", required = true, defaultValue = "1") long id,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "20") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		ShopReviewGood bean=new ShopReviewGood();
		bean.setAddDate(new Date());
		bean.setGoodDate(new Date());
		ShopReview shopReview=new ShopReview();
		shopReview.setId(id);
		bean.setShopReview(shopReview);
		bean.setUser(UserUtil.getCurrentUser());
		shopReviewGoodService.save(bean);

		return "redirect:/admin/shopreviewgood/list.htm";
	}
	@RequestMapping(value = "shopreviewgood/delete", method = RequestMethod.GET)
	public String delete(
			@RequestParam(value = "id", required = true, defaultValue = "1") long id,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "20") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		shopReviewGoodService.deleteById(id);
		return "redirect:/admin/shopreviewgood/list.htm";
	}
}
