package com.openyelp.actions.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.openyelp.article.entity.ArticleCatalog;
import com.openyelp.article.service.ArticleCatalogService;
import com.openyelp.data.core.Pagination;

@Controller
@RequestMapping(value = "admin")
public class ArticleCatalogManagerAction {

	@Autowired
	ArticleCatalogService articleCatalogService;

	@RequestMapping(value = "article_catalog/list", method = RequestMethod.GET)
	public String list(
			@RequestParam(value = "id", required = true, defaultValue = "1") int id,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "20") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		Pagination rs = articleCatalogService.pageByPid(id,curpage, pagesize);

		model.addAttribute("list", rs.getList());
		model.addAttribute("id", id);
		model.addAttribute("page", rs);
		model.addAttribute("curpage", curpage);
		model.addAttribute("pagesize", pagesize);

		return "admin/article/catalog/list";
	}

	@RequestMapping(value = "article_catalog/model_add", method = RequestMethod.POST)
	public String model_add(ArticleCatalog article, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		try {
			articleCatalogService.save(article);
			return "redirect:/admin/article_catalog/list.htm";
		} catch (Exception e) {
			e.printStackTrace();
			return "/admin/article/catalog/view_add";
		}

	}
	@RequestMapping(value = "article_catalog/model_update", method = RequestMethod.POST)
	public String model_update(ArticleCatalog catalog, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		try {
			articleCatalogService.update(catalog);
			return "redirect:/admin/article_catalog/list.htm";
		} catch (Exception e) {
			e.printStackTrace();
			return "/admin/article/catalog/view_add";
		}

	}
	@RequestMapping(value = "article_catalog/model_delete", method = RequestMethod.GET)
	public String model_delete(
			int id,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		articleCatalogService.deleteById(id);

		return "redirect:/admin/article_catalog/list.htm";
	}

	@RequestMapping(value = "article_catalog/view_add", method = RequestMethod.GET)
	public String view_add(HttpServletRequest request,Integer pid,
			HttpServletResponse response, Model model) {
		model.addAttribute("pid",pid);
		model.addAttribute("parent",articleCatalogService.findById(pid));
		return "/admin/article/catalog/view_add";
	}
}
