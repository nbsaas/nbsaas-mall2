package com.openyelp.actions.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ada.common.action.BaseAction;
import com.ada.data.core.Pagination;
import com.openyelp.data.service.UserService;
import com.openyelp.shiro.utils.UserUtil;
import com.openyelp.web.utils.FrontUtils;

@Controller
@RequestMapping(value = "user")
public class UserAction extends BaseAction {

	@Autowired
	UserService userService;

	@RequestMapping(value = "find_friends", method = {RequestMethod.GET,RequestMethod.POST})
	public String find_friends(
			@RequestParam(value = "name", required = true, defaultValue = "")	String name,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		
		long userid=UserUtil.getCurrentUser().getId();
		Pagination rs =	userService.findByFollowName(name, userid,curpage, pagesize);

		
		if (rs != null) {
			model.addAttribute("list", rs.getList());
			model.addAttribute("page", rs);
		}
		model.addAttribute("curpage", curpage);
		model.addAttribute("pagesize", pagesize);
		model.addAttribute("name", name);
		model.addAttribute("totalcount", rs.getTotalCount());
		model.addAttribute("firstno", rs.getFirstNo());
		model.addAttribute("endno", rs.getEndNo());
		model.addAttribute("siteindex", 4);

		return FrontUtils.getPath("user/find_friends");
	}

}
