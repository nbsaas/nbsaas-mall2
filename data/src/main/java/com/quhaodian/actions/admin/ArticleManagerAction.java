package com.quhaodian.actions.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ada.article.entity.Article;
import com.ada.article.entity.ArticleCatalog;
import com.ada.article.service.ArticleCatalogService;
import com.ada.article.service.ArticleService;
import com.ada.data.core.Pagination;

@Controller
@RequestMapping(value = "admin")
public class ArticleManagerAction {

	@Autowired
	ArticleService knowledgeItemService;
   @Autowired
   ArticleCatalogService articleCatalogService;
	@RequestMapping(value = "article/list", method = RequestMethod.GET)
	public String list(
			@RequestParam(value = "id", required = true, defaultValue = "1") int id,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "20") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		Pagination rs = knowledgeItemService.getPage(curpage, pagesize);

		model.addAttribute("list", rs.getList());
		model.addAttribute("id", id);
		model.addAttribute("page", rs);
		model.addAttribute("curpage", curpage);
		model.addAttribute("pagesize", pagesize);

		return "admin/article/article/list";
	}

	@RequestMapping(value = "article/model_add", method = RequestMethod.POST)
	public String model_add(Article article, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		try {
			knowledgeItemService.save(article);
			return "redirect:/admin/article/list.htm";
		} catch (Exception e) {
			e.printStackTrace();
			return "/admin/article/article/view_add";
		}

	}

	@RequestMapping(value = "article/model_update", method = RequestMethod.POST)
	public String model_update(Article article, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		try {
			knowledgeItemService.update(article);
			return "redirect:/admin/article/list.htm";
		} catch (Exception e) {
			e.printStackTrace();
			return "/admin/article/article/view_add";
		}

	}
	
	@RequestMapping(value = "article/model_delete", method = RequestMethod.GET)
	public String model_delete(
			long id,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		knowledgeItemService.deleteById(id);

		return "redirect:/admin/article/list.htm";
	}

	@RequestMapping(value = "article/view_add", method = RequestMethod.GET)
	public String view_add(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		
		List<ArticleCatalog> cs=	articleCatalogService.findChild(1);
		model.addAttribute("list", cs);
		return "/admin/article/article/view_add";
	}
	@RequestMapping(value = "article/view_update", method = RequestMethod.GET)
	public String view_update(long id,HttpServletRequest request,
			HttpServletResponse response, Model model) {
		List<ArticleCatalog> cs=	articleCatalogService.findChild(1);
		model.addAttribute("list", cs);
		Article article=knowledgeItemService.findById(id);
		model.addAttribute("article", article);
		
		
		return "/admin/article/article/view_update";
	}
}
