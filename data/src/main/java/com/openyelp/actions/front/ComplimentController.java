package com.openyelp.actions.front;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.openyelp.data.entity.UserCompliment;
import com.openyelp.data.service.UserComplimentService;
import com.openyelp.shiro.utils.UserUtil;
import com.openyelp.web.utils.FrontUtils;

@Controller
public class ComplimentController {

	
	@Autowired
	UserComplimentService userComplimentService;
	@RequiresUser
	@RequestMapping(value = "compliment_add", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String add(
			UserCompliment compliment,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		compliment.setState(0);
		compliment.setAddDate(new Date());
		compliment.setUserInfo(UserUtil.getCurrentUser());
		userComplimentService.save(compliment);
		return FrontUtils.redirect("/user_details_thanx.htm?id="+compliment.getUserInfo().getId()+"&curpage="+curpage+"&pagesize="+pagesize);

	}
	
	@RequiresUser
	@RequestMapping(value = "compliment_delete", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String delete(
			Long id,Long userid,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
         
		
		userComplimentService.deleteById(id);
		return FrontUtils.redirect("/user_details_thanx.htm?id="+userid+"&curpage="+curpage+"&pagesize="+pagesize);

	}
	
	@RequiresUser
	@RequestMapping(value = "compliment_ok", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String ok(
			Long id,Long userid,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		UserCompliment compliment=new UserCompliment();
		compliment.setId(id);
		compliment.setState(1);
		userComplimentService.update(compliment);
		return FrontUtils.redirect("/user_details_thanx.htm?id="+userid+"&curpage="+curpage+"&pagesize="+pagesize);

	}
}
