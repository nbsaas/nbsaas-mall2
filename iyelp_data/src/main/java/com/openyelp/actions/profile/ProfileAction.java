package com.openyelp.actions.profile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.openyelp.core.web.WebErrors;
import com.ada.data.core.Pagination;
import com.openyelp.data.entity.Photo;
import com.openyelp.data.entity.UserInfo;
import com.openyelp.data.entity.UserProfile;
import com.openyelp.data.entity.UserSetting;
import com.openyelp.data.service.PhotoService;
import com.openyelp.data.service.UserFriendRequestService;
import com.openyelp.data.service.UserFriendService;
import com.openyelp.data.service.UserProfileService;
import com.openyelp.data.service.UserService;
import com.openyelp.data.service.UserSettingService;
import com.openyelp.shiro.utils.UserUtil;
import com.openyelp.web.utils.FrontUtils;

@Controller
@RequestMapping(value = "profile")
public class ProfileAction {

	@Autowired
	UserProfileService userProfileService;

	@RequestMapping(value = "profile_bio", method = RequestMethod.GET)
	public String profile_bio(HttpServletRequest request,
			HttpServletResponse response, Model model) {

		UserProfile profile = UserUtil.getCurrentUser().getProfile();
		if (profile == null) {
			profile = new UserProfile();
		} else {
			profile = userProfileService.findById(profile.getId());
		}
		model.addAttribute("profile", profile);
		return FrontUtils.getPath("profile/profile_bio");
	}

	@RequestMapping(value = "profile_bio", method = RequestMethod.POST)
	public String profile_bioupdate(HttpServletRequest request, String name,
			UserProfile profile, HttpServletResponse response, Model model) {

		profile.setUser(UserUtil.getCurrentUser());
		userProfileService.update(profile);
		UserInfo info = UserUtil.getCurrentUser();
		info.setName(name);
		info = userService.update(info);
		UserUtil.setCurrentUser(info);
		UserUtil.getCurrentUser().setProfile(profile);
		model.addAttribute("message", "你的个人资料已被更新！");
		return FrontUtils.getPath("profile/profile");
	}

	@Autowired
	PhotoService photoService;

	@RequestMapping(value = "user_photos", method = RequestMethod.GET)
	public String user_photos(
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "9") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		Long id = UserUtil.getCurrentUser().getId();
		Pagination rs = photoService.pageByUser(id, curpage, pagesize);
		if (rs != null) {
			model.addAttribute("comments", rs.getList());
			model.addAttribute("page", rs);
		}
		model.addAttribute("curpage", curpage);
		model.addAttribute("pagesize", pagesize);
		model.addAttribute("id", id);
		model.addAttribute("totalcount", rs.getTotalCount());
		model.addAttribute("firstno", rs.getFirstNo());
		model.addAttribute("endno", rs.getEndNo());

		return FrontUtils.getPath("profile/user_photos");
	}

	@RequestMapping(value = "user_photos_add", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String user_photos_add(Photo photo, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		photo.setCatalog(1);
		photo.setUserInfo(UserUtil.getCurrentUser());
		photoService.save(photo);
		return FrontUtils.redirect("/profile/user_photos.htm");
	}

	@RequestMapping(value = "user_photos_set", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String user_photos_set(Long id, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		Long uid = UserUtil.getCurrentUser().getId();

		UserInfo userInfo = userService.updatePhoto(uid, id);
		UserUtil.setCurrentUser(userInfo);
		return FrontUtils.redirect("/profile/user_photos.htm");
	}

	@RequestMapping(value = "user_photos_update", method = RequestMethod.POST)
	public String user_photos_update(Photo photo, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		photoService.update(photo);
		return FrontUtils.redirect("/profile/user_photos.htm");
	}

	@RequestMapping(value = "user_photos_delete", method = RequestMethod.GET)
	public String user_photos_delete(Long id, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		photoService.deleteById(id);
		return FrontUtils.redirect("/profile/user_photos.htm");
	}

	@RequestMapping(value = "profile", method = RequestMethod.GET)
	public String profile(HttpServletRequest request,
			HttpServletResponse response, Model model) {

		return FrontUtils.getPath("profile/profile");
	}

	@RequestMapping(value = "profile_password", method = RequestMethod.GET)
	public String profile_password(HttpServletRequest request,
			HttpServletResponse response, Model model) {

		return FrontUtils.getPath("profile/profile_password");
	}

	@RequestMapping(value = "profile_password", method = RequestMethod.POST)
	public String profile_passwordwork(HttpServletRequest request,
			String confirm_password, String password, String oldpassword,
			HttpServletResponse response, Model model) {

		WebErrors errors = WebErrors.create(request);
		if (password == null) {
			errors.addErrorString("新密码不能为空");
		}
		if (oldpassword == null) {
			errors.addErrorString("老密码不能为空");
		}
		if (confirm_password == null) {
			errors.addErrorString("核实密码不能为空");
		}
		if (password != null) {
			if (!password.equals(confirm_password)) {
				errors.addErrorString("两次密码不一致");
			}
		}
		if (errors.getCount() == 0) {
			UserInfo u = userService.updatePassword(UserUtil
					.getCurrentShiroUser().getId(), oldpassword, password);
			if (u.getId() == -1) {
				errors.addErrorString("老密码不正确");
			}
			if (u.getId() == -2) {
				errors.addErrorString("两次密码不一致");

			}
			if (u.getId() > 0) {
				model.addAttribute("message", "修改密码成功");
				return FrontUtils.getPath("profile/profile");

			}
		} else {

		}

		errors.toModel(model);
		return FrontUtils.getPath("profile/profile_password");
	}

	@Autowired
	UserService userService;

	@RequestMapping(value = "profile_email_notifications", method = RequestMethod.GET)
	public String profile_email_notifications(String old_password,
			String password, String confirm_password,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		userService.updatePassword(UserUtil.getCurrentShiroUser().getId(),
				old_password, password);
		return FrontUtils.getPath("profile/profile_email_notifications");
	}

	@Autowired
	UserFriendRequestService friendRequestService;

	@RequestMapping(value = "profile_friends_invited", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String profile_friends_invited(
			HttpServletRequest request,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "key", required = true, defaultValue = "") String key,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletResponse response, Model model) {

		Long userid = UserUtil.getCurrentUser().getId();
		Pagination rs = friendRequestService.pageByUser(userid, key, curpage,
				pagesize);
		model.addAttribute("list", rs.getList());
		model.addAttribute("page", rs);
		model.addAttribute("curpage", curpage);
		model.addAttribute("pagesize", pagesize);
		return FrontUtils.getPath("profile/profile_friends_invited");
	}

	@RequestMapping(value = "profile_friends_invited_remove", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String profile_friends_invited_remove(
			HttpServletRequest request,
			Long id,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "key", required = true, defaultValue = "") String key,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletResponse response, Model model) {
		friendRequestService.deleteById(id);
		Long userid = UserUtil.getCurrentUser().getId();
		Pagination rs = friendRequestService.pageByUser(userid, key, curpage,
				pagesize);
		model.addAttribute("list", rs.getList());
		model.addAttribute("page", rs);
		model.addAttribute("curpage", curpage);
		model.addAttribute("pagesize", pagesize);
		return FrontUtils.getPath("profile/profile_friends_invited");
	}

	@Autowired
	UserFriendService userFriendService;

	@RequestMapping(value = "profile_friends_remove", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String profile_friends_remove(
			HttpServletRequest request,
			Long id,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "key", required = true, defaultValue = "") String key,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletResponse response, Model model) {
		userFriendService.deleteById(id);
		Long userid = UserUtil.getCurrentUser().getId();
		Pagination rs = userFriendService.pageByUser(userid, key, curpage,
				pagesize);
		model.addAttribute("list", rs.getList());
		model.addAttribute("page", rs);
		model.addAttribute("curpage", curpage);
		model.addAttribute("pagesize", pagesize);
		return FrontUtils.getPath("profile/profile_friends");
	}

	@RequestMapping(value = "profile_friends", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String profile_friends(
			HttpServletRequest request,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "key", required = true, defaultValue = "") String key,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletResponse response, Model model) {

		Long userid = UserUtil.getCurrentUser().getId();
		Pagination rs = userFriendService.pageByUser(userid, key, curpage,
				pagesize);
		model.addAttribute("list", rs.getList());
		model.addAttribute("page", rs);
		model.addAttribute("curpage", curpage);
		model.addAttribute("pagesize", pagesize);
		return FrontUtils.getPath("profile/profile_friends");
	}

	@RequestMapping(value = "profile_sharing", method = RequestMethod.GET)
	public String profile_sharing(HttpServletRequest request,
			HttpServletResponse response, Model model) {

		return FrontUtils.getPath("profile/profile_sharing");
	}

	@Autowired
	UserSettingService settingService;

	@RequestMapping(value = "profile_privacy", method = RequestMethod.GET)
	public String profile_privacy(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		Long userid = UserUtil.getCurrentUser().getId();
		model.addAttribute("setting", settingService.findByUser(userid));
		return FrontUtils.getPath("profile/profile_privacy");
	}

	@RequestMapping(value = "profile_privacy_save", method = {
			RequestMethod.GET, RequestMethod.POST })
	public String profile_privacy_save(UserSetting setting,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		Long userid = UserUtil.getCurrentUser().getId();
		if (setting.getBookmarksPublic() == null) {
			setting.setBookmarksPublic(0);
		}
		if (setting.getMemberSearch() == null) {
			setting.setMemberSearch(0);
		}
		settingService.update(setting);
		model.addAttribute("setting", settingService.findByUser(userid));
		return FrontUtils.redirect("/profile/profile_privacy.htm");
	}
}
