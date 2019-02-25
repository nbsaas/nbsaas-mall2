package com.quhaodian.haodian.data.apps;

import java.util.List;

import com.haoxuer.discover.area.data.entity.Area;
import com.haoxuer.discover.area.data.service.AreaService;
import com.haoxuer.discover.user.data.entity.UserInfo;

public class AreaApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AreaService service = ObjectFactory.get().getBean(AreaService.class);
		Area area=new Area();
		area.setName("中国");
		area.setCode("1");
		area.setLevelInfo(1);
		service.save(area);
		List<Area> ass  = service.list(0,1, null, null);

		for (Area item : ass) {
			System.out.println(item);
		}
	}


	public UserInfo get() {

		UserInfo info = new UserInfo();
		return info;
	}

}
