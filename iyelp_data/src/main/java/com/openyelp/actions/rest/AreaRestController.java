package com.openyelp.actions.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.openyelp.data.entity.Area;
import com.openyelp.data.service.AreaService;



@Controller
@RequestMapping(value = "area")
public class AreaRestController {
	
	@Autowired
	AreaService areaService;
	@RequestMapping(value = "querybylist", method = RequestMethod.GET)
	@ResponseBody
	public List<Area> findByArea(@RequestParam(value = "id", required = true, defaultValue = "1") int id){
		List<Area> result=areaService.findByParent(id);
		return result;
	}
	
	
	@RequestMapping(value = "querybycircle", method = RequestMethod.GET)
	@ResponseBody
	public List<Area> findByCircle(@RequestParam(value = "id", required = true, defaultValue = "1") int id){
		List<Area> result=areaService.pageByLevel(id,5,1,100).getList();
		return result;
	}

}
