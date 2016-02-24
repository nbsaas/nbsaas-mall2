package com.openyelp.actions.front;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.openyelp.data.core.Pagination;
import com.openyelp.data.service.FeedService;
import com.openyelp.shiro.utils.UserUtil;
import com.openyelp.web.utils.FrontUtils;



@Controller
@RequestMapping(value = "feed")
public class FeedController {
	
	@Autowired
	FeedService feedService;
	
	@RequestMapping(value = "area", method = RequestMethod.GET)
	public String area(
			@RequestParam(value = "id", required = true, defaultValue = "111") int areaid,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		Pagination rs = feedService.pageByArea(UserUtil.getCurrentCity().getId(),curpage, pagesize);

		model.addAttribute("list", rs.getList());
		model.addAttribute("areaid", areaid);
		model.addAttribute("page", rs);
		model.addAttribute("curpage", curpage);
		model.addAttribute("pagesize", pagesize);

		return FrontUtils.getPath("feed/list");
	}
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public String user(
			@RequestParam(value = "id", required = true, defaultValue = "111") long uid,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		Pagination rs = feedService.pageByUser(uid,curpage, pagesize);

		model.addAttribute("list", rs.getList());
		model.addAttribute("uid", uid);
		model.addAttribute("page", rs);
		model.addAttribute("curpage", curpage);
		model.addAttribute("pagesize", pagesize);

		return FrontUtils.getPath("feed/list");
	}
	
	@RequestMapping(value = "follow", method = RequestMethod.GET)
	public String follow(
			@RequestParam(value = "id", required = true, defaultValue = "1") long uid,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		Pagination rs = feedService.pageByFollow(uid,curpage, pagesize);

		model.addAttribute("list", rs.getList());
		model.addAttribute("uid", uid);
		model.addAttribute("page", rs);
		model.addAttribute("curpage", curpage);
		model.addAttribute("pagesize", pagesize);

		return FrontUtils.getPath("feed/list");
	}

	@RequestMapping(value = "friend", method = RequestMethod.GET)
	public String friend(
			@RequestParam(value = "id", required = true, defaultValue = "1") long uid,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		Pagination rs = feedService.pageByFriend(uid,curpage, pagesize);

		model.addAttribute("list", rs.getList());
		model.addAttribute("uid", uid);
		model.addAttribute("page", rs);
		model.addAttribute("curpage", curpage);
		model.addAttribute("pagesize", pagesize);

		return FrontUtils.getPath("feed/list");
	}


}
