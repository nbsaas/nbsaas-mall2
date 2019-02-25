package com.quhaodian.haodian.actions.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quhaodian.haodian.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.discover.user.data.entity.UserInfo;


@Controller
@RequestMapping(value = "admin")
public class UserManagerAction {

	@Autowired
	UserService userService;
	@RequestMapping(value = "users/list", method = RequestMethod.GET)
	public String list(
			@RequestParam(value = "id", required = true, defaultValue = "1") int id,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		Pagination rs =userService.getPage(curpage, pagesize);

		model.addAttribute("list", rs.getList());
		model.addAttribute("id", id);
		model.addAttribute("page", rs);
		model.addAttribute("curpage",curpage);
		model.addAttribute("pagesize",pagesize);

		return "admin/users/list";
	}
	
	@RequestMapping(value = "users/model_add", method = RequestMethod.POST)
	public String model_add(UserInfo user, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		try {
			UserInfo u=	null;
			if(u==null){
				userService.save(user);
				return "redirect:/admin/users/list.htm";
			}else{
				model.addAttribute("msg","用户名存在");
				return "/admin/users/view_add";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "/admin/users/view_add";
		}
	
	}
	

	@RequestMapping(value = "users/model_delete", method = RequestMethod.GET)
	public String model_delete(long id, HttpServletRequest request,
			HttpServletResponse response, Model model) {

		userService.deleteById(id);

		return "redirect:/admin/users/list.htm";
	}
	@RequestMapping(value = "users/view_add", method = RequestMethod.GET)
	public String view_add(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		
		
		return "/admin/users/view_add";
	}
}
