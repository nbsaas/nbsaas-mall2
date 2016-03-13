package com.openyelp.actions.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ada.area.dto.AreaDto;
import com.ada.area.entity.Area;
import com.ada.area.rest.AreaApi;

@Controller
@RequestMapping(value = "area")
public class AreaRestController {

	@Autowired
	AreaApi areaService;

	@RequestMapping(value = "querybylist")
	@ResponseBody
	public List<AreaDto> findByArea(@RequestParam(value = "id", required = true, defaultValue = "1") int id) {
		List<AreaDto> result = areaService.findByPid(id);
		return result;
	}

	@RequestMapping(value = "querybycircle")
	@ResponseBody
	public List<AreaDto> findByCircle(@RequestParam(value = "id", required = true, defaultValue = "1") int id) {
		List<AreaDto> result = areaService.findByPid(id);
		return result;
	}

}
