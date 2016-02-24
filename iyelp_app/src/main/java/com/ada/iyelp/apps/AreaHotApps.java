package com.ada.iyelp.apps;

import java.util.Date;

import com.openyelp.data.entity.Area;
import com.openyelp.data.entity.AreaHot;
import com.openyelp.data.service.AreaHotService;

public class AreaHotApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AreaHotService service = ObjectFactory.get().getBean(AreaHotService.class);
		Area area=new Area();
		area.setName("中国");
		area.setLevelinfo(1);
		area.setSortnum(0);
		area.setId(37);
		AreaHot hot=new AreaHot();
		hot.setArea(area);
		hot.setNum(1);
		hot.setAdddate(new Date());
		service.save(hot);
	}

}
