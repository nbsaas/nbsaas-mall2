package com.openyelp.actions.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ada.user.entity.UserFriendRequest;
import com.ada.user.service.UserFriendRequestService;
import com.openyelp.shiro.utils.UserUtil;




@RequestMapping(value = "friendrequest")
@Controller
public class UserFriendRequestAction {
	
	@Autowired
	UserFriendRequestService friendRequestService;
	
	@RequestMapping(value = "add", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String add(UserFriendRequest friendRequest,HttpServletRequest request, HttpServletResponse response,
			Model model){
		friendRequest.setUser(UserUtil.getCurrentUser());
		friendRequestService.save(friendRequest);
		return "success";
	}

}
