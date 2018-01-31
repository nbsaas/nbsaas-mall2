package com.quhaodian.haodian.actions.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.haodian.data.entity.Dictionary;
import com.quhaodian.haodian.data.service.DictionaryService;


@Controller
@RequestMapping(value = "admin")
public class DictionaryManagerAction {

	@Autowired
	DictionaryService dictionaryService;
	
	@RequestMapping(value = "dictionary/list", method = RequestMethod.GET)
	public String list(
			@RequestParam(value = "id", required = true, defaultValue = "1") int id,
			@RequestParam(value = "sorttype", required = true, defaultValue = "1") int sorttype,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		Pagination page = dictionaryService.page(curpage, pagesize);
		model.addAttribute("list", page.getList());
		model.addAttribute("page", page);
		model.addAttribute("sorttype", sorttype);
		model.addAttribute("curpage", page.getPageNo());
		model.addAttribute("pagesize", page.getPageSize());

		return "admin/dictionary/list";
	}
	@RequestMapping(value = "dictionary/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		return "admin/dictionary/index";
	}
	@RequestMapping(value = "dictionary/model_add", method = RequestMethod.POST)
	public String model_add(Dictionary dictionary, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		
		dictionaryService.save(dictionary);
		
		return "redirect:/admin/dictionary/list.htm";
	}
	@RequestMapping(value = "dictionary/model_delete", method = RequestMethod.GET)
	public String model_delete(int typeid, HttpServletRequest request,
			HttpServletResponse response, Model model) {

		dictionaryService.deleteById(typeid);

		return "redirect:/admin/dictionary/list.htm";
	}
}
