package com.quhaodian.haodian.data.apps;

import java.util.List;

import com.quhaodian.area.data.entity.Area;
import com.quhaodian.area.data.service.AreaService;
import com.quhaodian.user.data.entity.UserInfo;

public class AreaApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AreaService service = ObjectFactory.get().getBean(AreaService.class);
		List<Area> ass  = service.list(3,1, null, null);

		for (Area area : ass) {
			System.out.println(area);
		}
	}


	public UserInfo get() {

		UserInfo info = new UserInfo();
		return info;
	}

}
