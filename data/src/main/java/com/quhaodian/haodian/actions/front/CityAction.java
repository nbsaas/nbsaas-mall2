package com.quhaodian.haodian.actions.front;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quhaodian.haodian.shiro.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.haoxuer.discover.area.data.entity.Area;
import com.haoxuer.discover.area.data.service.AreaService;
import com.quhaodian.haodian.web.utils.FrontUtils;

@Controller
public class CityAction {

	@Autowired
	AreaService areaService;

	@RequestMapping(value = "city", method = RequestMethod.GET)
	public String city(
			@RequestParam(value = "id", required = true, defaultValue = "100") int id,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		Area area = areaService.findById(id);
		model.addAttribute("city", area);
		UserUtil.setCurrentCity(area);
		
		return FrontUtils.redirect("index.htm");
	}
}
