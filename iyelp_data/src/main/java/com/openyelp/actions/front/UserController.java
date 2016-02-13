package com.openyelp.actions.front;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.openyelp.data.core.Pagination;
import com.openyelp.data.entity.UserInfo;
import com.openyelp.data.service.EventInfoService;
import com.openyelp.data.service.PhotoService;
import com.openyelp.data.service.ShopBookMarksService;
import com.openyelp.data.service.ShopReviewListService;
import com.openyelp.data.service.ShopReviewService;
import com.openyelp.data.service.UserComplimentService;
import com.openyelp.data.service.UserFollowService;
import com.openyelp.data.service.UserFriendService;
import com.openyelp.data.service.UserService;
import com.openyelp.web.utils.FrontUtils;

@Controller
public class UserController {

	private Logger logger = LoggerFactory.getLogger("ada");
	@Autowired
	UserService userService;

	@Autowired
	UserComplimentService userComplimentService;

	@RequestMapping(value = "user_details", method = RequestMethod.GET)
	public String user_details(
			@RequestParam(value = "id", required = true, defaultValue = "-100") Long id,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		UserInfo u = getuserinfo(id, model);
		logger.error("id:" + u.getId());
		if (u.getId() < 0) {
			return toindex();
		}
		Pagination friends = friendService.pageByUser(id, 1, 4);
		model.addAttribute("friends", friends.getList());
		
		Pagination compliments = userComplimentService.pageByUser(u.getId(), 1,
				1, 5);
		model.addAttribute("compliments", compliments.getList());
		Pagination reviews = reviewService.pageByUser(id, 1, 10);
		model.addAttribute("reviews", reviews.getList());

		
		model.addAttribute("siteindex",2);

		return FrontUtils.getPath("user/user_details");
	}

	private String toindex() {
		return FrontUtils.redirect("/index.htm");
	}

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
	
	@Autowired
	ShopBookMarksService bookMarksService;

	@RequestMapping(value = "user_details_bookmarks", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String user_details_bookmarks(
			@RequestParam(value = "id", required = true, defaultValue = "-100") Long id,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		UserInfo u = getuserinfo(id, model);
		if (u.getId() < 0) {
			return toindex();
		}
		
		Pagination rs = bookMarksService.pageByUser(id, curpage, pagesize);
			model.addAttribute("list", rs.getList());
			model.addAttribute("page", rs);
		model.addAttribute("curpage", curpage);
		model.addAttribute("pagesize", pagesize);
		
		model.addAttribute("siteindex",2);
		return FrontUtils.getPath("user/user_details_bookmarks");
	}

	@Autowired
	EventInfoService eventInfoService;

	@RequestMapping(value = "user_details_events", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String user_details_events(
			@RequestParam(value = "id", required = true, defaultValue = "-100") Long id,
			@RequestParam(value = "type", required = true, defaultValue = "1") int type,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		UserInfo u = getuserinfo(id, model);
		if (u.getId() < 0) {
			return toindex();
		}
		if (type == 1) {
			Pagination rs = eventInfoService.pageByMeAdd(id, curpage, pagesize);
			model.addAttribute("list", rs.getList());
			model.addAttribute("page", rs);
		} else if (type == 2) {
			Pagination rs = eventInfoService.pageByMe(id, curpage, pagesize);
			model.addAttribute("list", rs.getList());
			model.addAttribute("page", rs);
		} else if (type == 3) {
			Pagination rs = eventInfoService.pageByJoin(id, 1, curpage,
					pagesize);
			model.addAttribute("list", rs.getList());
			model.addAttribute("page", rs);
		} else if (type == 4) {
			Pagination rs = eventInfoService.pageByJoin(id, 2, curpage,
					pagesize);
			model.addAttribute("list", rs.getList());
			model.addAttribute("page", rs);
		}
		model.addAttribute("curpage", curpage);
		model.addAttribute("type", type);
		model.addAttribute("pagesize", pagesize);
		
		model.addAttribute("siteindex",2);
		return FrontUtils.getPath("user/user_details_events");
	}

	@Autowired
	UserFollowService followService;

	@RequestMapping(value = "user_details_following", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String user_details_following(
			@RequestParam(value = "id", required = true, defaultValue = "-100") Long id,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "12") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		UserInfo u = getuserinfo(id, model);
		if (u.getId() < 0) {
			return toindex();
		}
		Pagination rs = followService.pageByUser(id, curpage, pagesize);
		if (rs != null) {
			model.addAttribute("list", rs.getList());
			model.addAttribute("page", rs);
		}
		model.addAttribute("curpage", curpage);
		model.addAttribute("pagesize", pagesize);
		
		model.addAttribute("siteindex",2);
		return FrontUtils.getPath("user/user_details_following");
	}

	@Autowired
	UserFriendService friendService;

	@RequestMapping(value = "user_details_friends", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String user_details_friends(
			@RequestParam(value = "id", required = true, defaultValue = "-100") Long id,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		UserInfo u = getuserinfo(id, model);
		if (u.getId() < 0) {
			return toindex();
		}
		Pagination rs = friendService.pageByUser(id, curpage, pagesize);
		if (rs != null) {
			model.addAttribute("list", rs.getList());
			model.addAttribute("page", rs);
		}
		model.addAttribute("curpage", curpage);
		model.addAttribute("pagesize", pagesize);
		
		model.addAttribute("siteindex",2);

		return FrontUtils.getPath("user/user_details_friends");
	}
	
	@Autowired
	ShopReviewListService listService;

	@RequestMapping(value = "user_details_lists", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String user_details_lists(
			@RequestParam(value = "id", required = true, defaultValue = "-100") Long id,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		UserInfo u = getuserinfo(id, model);
		if (u.getId() < 0) {
			return toindex();
		}
		
		model.addAttribute("siteindex",2);
		
		Pagination rs = listService.pageByUser(id, curpage, pagesize);
		if (rs != null) {
			model.addAttribute("list", rs.getList());
			model.addAttribute("page", rs);
		}
		model.addAttribute("curpage", curpage);
		model.addAttribute("pagesize", pagesize);

		return FrontUtils.getPath("user/user_details_lists");
	}

	@Autowired
	ShopReviewService reviewService;

	@RequestMapping(value = "user_details_reviews_self", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String user_details_reviews_self(
			@RequestParam(value = "id", required = true, defaultValue = "-100") Long id,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		UserInfo u = getuserinfo(id, model);
		if (u.getId() < 0) {
			return toindex();
		}

		Pagination rs = reviewService.pageByUser(id, curpage, pagesize);
		if (rs != null) {
			model.addAttribute("list", rs.getList());
			model.addAttribute("page", rs);
		}
		model.addAttribute("curpage", curpage);
		model.addAttribute("pagesize", pagesize);
		model.addAttribute("siteindex",2);

		return FrontUtils.getPath("user/user_details_reviews_self");
	}

	@RequestMapping(value = "user_details_thanx", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String user_details_thanx(
			@RequestParam(value = "id", required = true, defaultValue = "-100") Long id,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		UserInfo u = getuserinfo(id, model);
		if (u.getId() < 0) {
			return toindex();
		}

		Pagination rs = userComplimentService.pageByUser(u.getId(), 1, curpage,
				pagesize);
		if (rs != null) {
			model.addAttribute("compliments", rs.getList());
			model.addAttribute("page", rs);
		}
		model.addAttribute("curpage", curpage);
		model.addAttribute("pagesize", pagesize);
		Pagination unread = userComplimentService.pageByUser(u.getId(), 0, 1,
				10);
		if (unread != null) {
			model.addAttribute("unreads", unread.getList());
		}
		model.addAttribute("siteindex",2);

		return FrontUtils.getPath("user/user_details_thanx");
	}
	
	@Autowired
	PhotoService photoService;

	@RequestMapping(value = "user_details_quicktips", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String user_details_quicktips(
			@RequestParam(value = "id", required = true, defaultValue = "-100") Long id,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		UserInfo u = getuserinfo(id, model);
		if (u.getId() < 0) {
			return toindex();
		}
		
		model.addAttribute("siteindex",2);

		return FrontUtils.getPath("user/user_details_quicktips");
	}
	
	
	@RequestMapping(value = "user_photos", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String user_photos(
			@RequestParam(value = "id", required = true, defaultValue = "-100") Long id,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "30") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		UserInfo u = getuserinfo(id, model);
		if (u.getId() < 0) {
			return toindex();
		}
		
		model.addAttribute("siteindex",2);
		

		Pagination rs = photoService.pageByUser(u.getId(), curpage,
				pagesize);
		if (rs != null) {
			model.addAttribute("list", rs.getList());
			model.addAttribute("page", rs);
		}
		model.addAttribute("curpage", curpage);
		model.addAttribute("pagesize", pagesize);
		

		return FrontUtils.getPath("user/user_photos");
	}

}
