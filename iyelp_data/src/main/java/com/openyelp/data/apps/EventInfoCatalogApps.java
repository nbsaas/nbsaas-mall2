package com.openyelp.data.apps;

import com.openyelp.data.entity.EventInfoCategory;
import com.openyelp.data.service.EventInfoCategoryService;

public class EventInfoCatalogApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventInfoCategoryService service=ObjectFactory.get().getBean(EventInfoCategoryService.class);
		EventInfoCategory bean=new EventInfoCategory();
		service.save(bean);
	}

}
