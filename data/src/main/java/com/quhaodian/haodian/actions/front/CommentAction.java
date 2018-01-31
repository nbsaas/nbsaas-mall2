package com.quhaodian.haodian.actions.front;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quhaodian.haodian.data.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ada.common.utils.HttpUtils;
import com.quhaodian.haodian.data.entity.Comment;

@Controller
@RequestMapping(value = "comment")
public class CommentAction {

	@Autowired
    CommentService commentService;
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(Comment comment,HttpServletRequest request,
			HttpServletResponse response, Model model){
		comment.setIp(HttpUtils.getIp(request));
		commentService.save(comment);
		model.addAttribute("msg","ok");
		return "msg";
	}
}
