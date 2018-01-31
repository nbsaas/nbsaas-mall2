package com.quhaodian.haodian.actions.profile;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quhaodian.haodian.data.entity.UserCity;
import com.quhaodian.haodian.data.service.UserCityService;
import com.quhaodian.haodian.shiro.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.haodian.web.utils.FrontUtils;

@Controller
@RequestMapping(value = "profile")
public class LocationAction {

	@Autowired
    UserCityService service;

	@RequestMapping(value = "profile_location_add_or_edit", method = RequestMethod.GET)
	public String profile_location_add_or_edit(
			@RequestParam(value = "id", required = true, defaultValue = "-1") long id,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		UserCity city = new UserCity();
		if (id > 0) {
			city = service.findById(id);
		}else{
			city.setId(-1l);
		}
		model.addAttribute("cityitem", city);
		return FrontUtils.getPath("profile/profile_location_add_or_edit");
	}

	@RequestMapping(value = "profile_location_save", method = RequestMethod.POST)
	public String profile_location_save(UserCity city,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		if(city.getId()>0){
			service.update(city);
		}else{
			city.setUser(UserUtil.getCurrentUser());
			service.save(city);
		}
		
		model.addAttribute("city", city);
		return FrontUtils.getPath("profile/profile_location_add_or_edit");
	}

	@RequestMapping(value = "profile_location", method = RequestMethod.GET)
	public String profile_location(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		Pagination p = service.findByUser(UserUtil.getCurrentUser().getId(), 1,
				100);
		List list = p.getList();
		model.addAttribute("list", list);
		return FrontUtils.getPath("profile/profile_location");
	}
}