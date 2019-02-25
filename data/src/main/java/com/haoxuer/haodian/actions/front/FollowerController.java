package com.haoxuer.haodian.actions.front;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haoxuer.haodian.shiro.utils.UserUtil;
import com.haoxuer.haodian.web.utils.FrontUtils;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haoxuer.discover.userfriend.data.entity.UserFollow;
import com.haoxuer.discover.user.data.entity.UserInfo;
import com.haoxuer.discover.userfriend.data.service.UserFollowService;

@Controller
public class FollowerController {

	
	@Autowired
	UserFollowService userFollowService;
	
	
	@ResponseBody
	@RequiresUser
	@RequestMapping(value = "follower_add", method = RequestMethod.GET)
	public String add(
			@RequestParam(value = "id", required = true, defaultValue = "-100") Long id,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		
		if(id>0){
			UserFollow follow=new UserFollow();
			follow.setUser(UserUtil.getCurrentUser());
			UserInfo friend=new UserInfo();
			friend.setId(id);
			follow.setFollower(friend);
			UserFollow result=userFollowService.save(follow);
			if (result!=null&&result.getId()>0) {
				return "success";
			}else{
				return "erro";
			}
		}else{
			
		}
		
		return FrontUtils.getPath("user/user_details");
	}
 
	@ResponseBody
	@RequiresUser
	@RequestMapping(value = "follower_remove", method = RequestMethod.GET)
	public String remove(
			@RequestParam(value = "id", required = true, defaultValue = "-100") Long id,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		if(id>0){
			UserFollow follow=new UserFollow();
			follow.setUser(UserUtil.getCurrentUser());
			UserInfo friend=new UserInfo();
			friend.setId(id);
			follow.setFollower(friend);
			UserFollow result=userFollowService.remove(follow);
			if (result!=null&&result.getId()>0) {
				return "success";
			}else{
				return "erro";
			}
		}else{
			
		}
		
		return FrontUtils.getPath("user/user_details");
	}
	
}
