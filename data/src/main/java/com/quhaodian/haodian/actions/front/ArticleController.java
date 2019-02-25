package com.quhaodian.haodian.actions.front;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haoxuer.discover.web.controller.front.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.haoxuer.discover.article.data.service.ArticleService;
import com.quhaodian.haodian.web.utils.FrontUtils;


@Controller
@RequestMapping(value = "article")
public class ArticleController extends BaseController{

	
	@Autowired
	ArticleService articleService;
	
	@RequestMapping(value = "view", method = RequestMethod.GET)
	public String user_details(
			@RequestParam(value = "id", required = true, defaultValue = "1") Long id,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		
		model.addAttribute("articleitem", articleService.findById(id));
		
		return getView("article/view");

	}
}
