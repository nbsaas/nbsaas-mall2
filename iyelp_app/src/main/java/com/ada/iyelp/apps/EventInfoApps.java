package com.ada.iyelp.apps;

import com.ada.data.core.Pagination;
import com.openyelp.data.service.EventInfoService;

public class EventInfoApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventInfoService service=ObjectFactory.get().getBean(EventInfoService.class);
		String start_date = null;
		Integer[] c=null;
		String end_date = null;
		String sort_by = null;
		Pagination ps=service.pageByNew(111, 1, 3);
		System.out.println(ps.getList());
//		Pagination p=service.browse(11l, start_date, end_date, sort_by, c, null, 1, 10);
//		System.out.println(p);
	}

}
