package com.haoxuer.haodian.actions.front;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haoxuer.haodian.data.service.ShopReviewGoodService;
import com.haoxuer.haodian.shiro.utils.UserUtil;
import com.haoxuer.haodian.web.utils.FrontUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.haoxuer.discover.data.core.Pagination;

@Controller
public class ShopReviewGoodController {

	@Autowired
  ShopReviewGoodService shopReviewGoodService;

	@RequestMapping(value = "shopreviewgood/list", method = RequestMethod.GET)
	public String list(
			@RequestParam(value = "id", required = true, defaultValue = "111") int areaid,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "20") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		Pagination rs = shopReviewGoodService.pageByArea(UserUtil.getCurrentCity().getId(),curpage, pagesize);

		model.addAttribute("list", rs.getList());
		model.addAttribute("areaid", areaid);
		model.addAttribute("page", rs);
		model.addAttribute("curpage", curpage);
		model.addAttribute("pagesize", pagesize);

		return FrontUtils.getPath("shopreviewgood/list");
	}
	
}