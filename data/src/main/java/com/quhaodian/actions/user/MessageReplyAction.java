package com.quhaodian.actions.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quhaodian.actions.entity.Back;
import com.quhaodian.data.entity.MessageReply;
import com.quhaodian.data.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ada.data.core.Pagination;
import com.quhaodian.data.service.MessageReplyService;
import com.quhaodian.shiro.utils.UserUtil;
import com.quhaodian.web.utils.FrontUtils;

@Controller
@RequestMapping(value = "user")
public class MessageReplyAction {

	@Autowired
	MessageReplyService messageReplyService;
	
	@Autowired
    MessagesService messagesService;

	@RequestMapping(value = "messages_reply", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String messages_sends(
            @RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
            @RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
            MessageReply messageReply, HttpServletRequest request,
            HttpServletResponse response, Model model) {
		try {

			messageReply.setUser(UserUtil.getCurrentUser());
			messageReplyService.save(messageReply);
		} catch (Exception e) {
			
		}
		return FrontUtils.redirect("/user/messages_list_view.htm?id="
				+ messageReply.getMessage().getId());
	}

	@ResponseBody
	@RequestMapping(value = "messages_reply_ajax", method = {
			RequestMethod.GET, RequestMethod.POST })
	public Back messages_sends_ajax(
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			MessageReply messageReply, HttpServletRequest request,
			HttpServletResponse response, Model model) {

		Back result = new Back();
		try {

			messageReply.setUser(UserUtil.getCurrentUser());
			messageReplyService.save(messageReply);
			result.setSuccess(true);

		} catch (Exception e) {
			result.setSuccess(false);
		}

		return result;
	}

	@RequestMapping(value = "messages_list_view", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String messages_list(
			Long id,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			MessageReply messageReply, HttpServletRequest request,
			HttpServletResponse response, Model model) {

		Pagination rs = messageReplyService
				.pageByMessage(id, curpage, pagesize);
		if (rs != null) {
			model.addAttribute("list", rs.getList());
			model.addAttribute("page", rs);
		}
		model.addAttribute("message", messagesService.findById(id));
		model.addAttribute("curpage", curpage);
		model.addAttribute("pagesize", pagesize);
		model.addAttribute("totalcount", rs.getTotalCount());
		model.addAttribute("firstno", rs.getFirstNo());
		model.addAttribute("endno", rs.getEndNo());
		model.addAttribute("id", id);
		return FrontUtils.getPath("user/messages/view");
	}

}
