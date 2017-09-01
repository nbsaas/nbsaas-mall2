package com.openyelp.actions.front;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ada.user.data.entity.UserInfo;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.openyelp.data.service.UserService;
import com.openyelp.shiro.filter.UsernamePasswordCaptchaToken;
import com.openyelp.shiro.utils.UserUtil;
import com.openyelp.web.utils.FrontUtils;

/**
 * 登录controller
 * 
 * @author ty
 * @date 2015年1月14日
 */
@Controller
public class LoginController {

	/**
	 * 默认页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "loginxxx", method = RequestMethod.GET)
	public String loginxxx() {
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated() || subject.isRemembered()) {
			return "redirect:" + "login.htm";
		}
		return "login";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response, Model model) {
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			if (UserUtil.getCurrentUser().getId() > 0) {
				return FrontUtils.redirect("/index.htm");
			} else {
				subject.logout();
			}
		}
		return FrontUtils.getPath("login");
	}

	@RequestMapping(value = "qqlogin")
	public String qqlogin(HttpServletRequest request, HttpServletResponse response, Model model) {
		return FrontUtils.getPath("qqlogin");
	}

	@RequestMapping(value = "qqlogin2")
	public String qqlogin2(String access_token, String openid, HttpServletRequest request, HttpServletResponse response,
			Model model) {
//		try {
//			Connection con = HttpConnection.connect("https://graph.qq.com/user/get_user_info");
//			con.data("oauth_consumer_key", "101295055");
//			con.data("access_token", access_token);
//			con.data("openid", openid);
//			con.data("format", "json");
//			String body;
//			body = con.execute().body();
//			JsonParser parser = new JsonParser();
//			JsonElement e = parser.parse(body);
//			String nickname = e.getAsJsonObject().get("nickname").getAsString();
//			String figureurl_qq_1 = e.getAsJsonObject().get("figureurl_qq_1").getAsString();
//			UserInfo user = userService.loginqq(openid, nickname, figureurl_qq_1);
//			if (user!=null) {
//				Subject subject = SecurityUtils.getSubject();
//				if (!subject.isAuthenticated()) {
//					UsernamePasswordCaptchaToken token = new UsernamePasswordCaptchaToken();
//					token.setUsername(openid);
//					token.setPassword("123456".toCharArray());
//					try {
//						subject.login(token);
//					} catch (Exception ex) {
//						ex.printStackTrace();
//					}
//					if (subject.isAuthenticated()) {
//						return "redirect:" + "/index.htm";
//					} else {
//						return "login";
//					}
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		return FrontUtils.getPath("qqlogin");
	}

	@Autowired
	UserService userService;

	/**
	 * 登录失败
	 * 
	 * @param userName
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String fail(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String userName, Model model) {
		model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, userName);
		return FrontUtils.getPath("login");
	}

	/**
	 * 登录失败
	 * 
	 * @param userName
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "login1x", method = RequestMethod.POST)
	public String fail(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String userName, String password,
			Model model) {
		model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, userName);
		Subject subject = SecurityUtils.getSubject();
		if (!subject.isAuthenticated()) {
			UsernamePasswordCaptchaToken token = new UsernamePasswordCaptchaToken();
			token.setUsername(userName);
			token.setPassword(password.toCharArray());
			try {
				subject.login(token);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (subject.isAuthenticated()) {
				return "redirect:" + "/admin/index.htm";
			} else {
				return "login";
			}
		}
		return "login";
	}

	/**
	 * 登出
	 * 
	 * @param userName
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "logout")
	public String logout(Model model) {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return FrontUtils.getPath("login");
	}

	@RequestMapping(value = "loginwork")
	public String loginok(String username, String password, Model model) {

		AuthenticationToken token = new UsernamePasswordToken(username, password);
		try {
			SecurityUtils.getSubject().login(token);
			// 更新消息数量
			// pushBadgesCount();
		} catch (AuthenticationException e) {
			if (e instanceof UnknownAccountException) {
				model.addAttribute("msg", "用户不存在");
			} else if (e instanceof LockedAccountException) {
				model.addAttribute("msg", "用户被禁用");
			} else {
				model.addAttribute("msg", "用户认证失败");
			}
		}

		if (SecurityUtils.getSubject().hasRole("admin")) {
			return "admin/home";
		} else {
			if (SecurityUtils.getSubject().isAuthenticated()) {
				return FrontUtils.redirect("/index.htm");
			} else {
				return FrontUtils.getPath("login");
			}
		}
	}

}
