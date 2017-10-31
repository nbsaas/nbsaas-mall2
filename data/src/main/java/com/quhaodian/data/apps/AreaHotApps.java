package com.quhaodian.data.apps;

import java.util.Date;

import com.ada.area.data.entity.Area;
import com.quhaodian.data.entity.AreaHot;
import com.quhaodian.data.service.AreaHotService;

public class AreaHotApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AreaHotService service = ObjectFactory.get().getBean(AreaHotService.class);
		Area area=new Area();
		area.setName("中国");
		area.setLevelInfo(1);
		area.setSortNum(0);
		area.setId(37);
		AreaHot hot=new AreaHot();
		hot.setArea(area);
		hot.setNum(1);
		hot.setAdddate(new Date());
		service.save(hot);
	}

}
