package com.openyelp.actions.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ada.data.core.Pagination;
import com.ada.user.data.entity.UserInfo;
import com.openyelp.data.entity.Messages;
import com.openyelp.data.service.MessagesService;
import com.openyelp.data.service.UserService;
import com.openyelp.shiro.utils.UserUtil;
import com.openyelp.web.utils.FrontUtils;

@Controller
@RequestMapping(value = "user")
public class MessageAction {

	@Autowired
	MessagesService messagesService;
	@Autowired
	UserService userService;

	@RequestMapping(value = "messages", method = RequestMethod.GET)
	public String messages(
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		Pagination rs = messagesService.pageByReceive(UserUtil.getCurrentUser()
				.getId(), curpage, pagesize);
		if (rs != null) {
			model.addAttribute("list", rs.getList());
			model.addAttribute("page", rs);
		}
		model.addAttribute("curpage", curpage);
		model.addAttribute("pagesize", pagesize);
		model.addAttribute("totalcount", rs.getTotalCount());
		model.addAttribute("firstno", rs.getFirstNo());
		model.addAttribute("endno", rs.getEndNo());
		model.addAttribute("siteindex",5);

		return FrontUtils.getPath("user/messages");
	}

	@RequestMapping(value = "messages_delete_from", method = RequestMethod.GET)
	public String delete(
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			Long id,Long[] messageid, HttpServletRequest request, HttpServletResponse response,
			Model model) {
		if (messageid!=null) {
			messagesService.removeByFrom(messageid);

		}

		return FrontUtils.redirect("/user/messages.htm");
	}
	
	@RequestMapping(value = "messages_delete_to", method = RequestMethod.GET)
	public String deleteto(
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			Long id,Long[] messageid, HttpServletRequest request, HttpServletResponse response,
			Model model) {
		if (messageid!=null) {
			messagesService.removeByTo(messageid);
		}

		return FrontUtils.redirect("/user/messages_sends.htm");
	}

	@RequestMapping(value = "messages_sends", method = RequestMethod.GET)
	public String messages_sends(
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		Pagination rs = messagesService.pageBySend(UserUtil.getCurrentUser()
				.getId(), curpage, pagesize);
		if (rs != null) {
			model.addAttribute("list", rs.getList());
			model.addAttribute("page", rs);
		}
		model.addAttribute("curpage", curpage);
		model.addAttribute("pagesize", pagesize);
		model.addAttribute("totalcount", rs.getTotalCount());
		model.addAttribute("firstno", rs.getFirstNo());
		model.addAttribute("endno", rs.getEndNo());
		return FrontUtils.getPath("user/messages/sends");
	}

	@RequestMapping(value = "messages_write", method = RequestMethod.GET)
	public String action_send_form(
			@RequestParam(value = "name", required = true, defaultValue = "") String name,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		model.addAttribute("name", name);
		return FrontUtils.getPath("user/messages/write");
	}

	@RequestMapping(value = "messages_action_send", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String action_send(Messages messages, String name,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		UserInfo u = userService.findByName(name);
		if (u == null) {
			model.addAttribute("msg", "该用户不存在");
			return FrontUtils.getPath("user/messages/write");
		} else {
			messages.setFrom(UserUtil.getCurrentUser());
			messages.setTo(u);
			messagesService.send(messages);
			return FrontUtils.redirect("/user/messages_sends.htm");

		}

	}

}
