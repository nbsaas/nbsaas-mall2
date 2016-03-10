package com.openyelp.data.apps;

import java.util.List;

import com.ada.area.entity.Area;
import com.ada.area.page.AreaPage;
import com.ada.area.service.AreaService;
import com.ada.data.core.Pagination;
import com.ada.data.page.Page;
import com.openyelp.data.entity.UserInfo;

public class AreaApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AreaService service = ObjectFactory.get().getBean(AreaService.class);
		AreaPage as = service.pageByLevelState(3,1, 1, 10);

		System.out.println(as);
		List<Area> ass = (List<Area>) as.getList();
		for (Area area : ass) {
			System.out.println(area);
		}
	}

	private static void list() {
		AreaService service = ObjectFactory.get().getBean(AreaService.class);
		AreaPage as = service.pageByLevel(5, 1, 10);

		System.out.println(as);
		List<Area> ass = (List<Area>) as.getList();
		for (Area area : ass) {
			System.out.println(area);
		}
	}

	private static void add() {
		AreaService service = ObjectFactory.get().getBean(AreaService.class);
		Area area = new Area();
		area.setName("中国");
		area.setLevelinfo(1);
		area.setSortnum(0);
		service.save(area);
		List<Area> as = service.findByHot(10);
		for (Area area2 : as) {
			System.out.println(area2.getName());
			System.out.println(area2.getId());
		}
	}

	public UserInfo get() {

		UserInfo info = new UserInfo();
		return info;
	}

}
