package com.openyelp.actions.front;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.openyelp.data.core.Pagination;
import com.openyelp.data.entity.ShopReviewList;
import com.openyelp.data.entity.UserInfo;
import com.openyelp.data.service.ShopReviewListService;
import com.openyelp.data.service.UserService;
import com.openyelp.shiro.utils.UserUtil;
import com.openyelp.web.utils.FrontUtils;

@Controller
@RequestMapping(value = "user_favorites")
public class UserFavorites {

	
	
	@RequiresUser
	@RequestMapping(value = "list_search", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String list_search(
			@RequestParam(value = "key", required = true, defaultValue = "") String key,
			@RequestParam(value = "find_desc", required = true, defaultValue = "西安") String find_desc,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int pageNo,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pageSize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		
		
		Pagination rs = listService.pageByArea(key,find_desc, pageNo, pageSize);
		model.addAttribute("list", rs.getList());
		model.addAttribute("page", rs);

		model.addAttribute("curpage", pageNo);
		model.addAttribute("pagesize", pageSize);
		model.addAttribute("find_desc", find_desc);
		model.addAttribute("key", key);

		return FrontUtils.getPath("user_favorites/list_search");
	}

	@RequiresUser
	@RequestMapping(value = "create_list", method = RequestMethod.GET)
	public String index(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		return FrontUtils.getPath("user_favorites/create_list");
	}

	@Autowired
	ShopReviewListService listService;

	@RequiresUser
	@RequestMapping(value = "create_list", method = RequestMethod.POST)
	public String create_list(ShopReviewList list, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		list.setUser(UserUtil.getCurrentUser());
		list.setArea(UserUtil.getCurrentCity());
		ShopReviewList l = listService.save(list);
		model.addAttribute("list", l);
		return FrontUtils.redirect("/user_favorites/view_list.htm?id="
				+ l.getId());
	}

	@RequiresUser
	@RequestMapping(value = "update_list", method = RequestMethod.POST)
	public String update(ShopReviewList list, HttpServletRequest request,
			HttpServletResponse response, Model model) {

		ShopReviewList l = listService.update(list);
		model.addAttribute("list", l);
		model.addAttribute("msg", "已更新。");
		return FrontUtils.getPath("user_favorites/favorites");
	}

	@RequiresUser
	@RequestMapping(value = "view_list", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String view(Long id, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		model.addAttribute("msg", "已更新。");
		ShopReviewList l = listService.findById(id);
		model.addAttribute("list", l);
		return FrontUtils.getPath("user_favorites/favorites");
	}

	@RequiresUser
	@RequestMapping(value = "list", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String list(Long id, HttpServletRequest request,
			HttpServletResponse response, Model model) {

		UserInfo u = getuserinfo(id, model);
		if (u.getId() < 0) {
			return toindex();
		}

		model.addAttribute("msg", "已更新。");
		ShopReviewList l = listService.findById(id);
		model.addAttribute("list", l);
		return FrontUtils.getPath("user/user_lists");
	}

	private String toindex() {
		return FrontUtils.redirect("/index.htm");
	}

	@Autowired
	UserService userService;

	private UserInfo getuserinfo(Long id, Model model) {
		UserInfo info = userService.findById(id);
		if (info == null) {
			info = new UserInfo();
			info.setId(-100l);
		}
		model.addAttribute("userinfo", info);
		model.addAttribute("id", id);
		return info;
	}

	@RequiresUser
	@RequestMapping(value = "delete_list", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String delete(Long id, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		model.addAttribute("msg", "已更新。");
		listService.deleteById(id);
		return FrontUtils.redirect("/user_details_lists.htm?id="
				+ UserUtil.getCurrentUser().getId());
	}

}
