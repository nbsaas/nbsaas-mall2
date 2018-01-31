package com.quhaodian.haodian.data.apps;

import com.quhaodian.haodian.data.entity.EventInfoCategory;
import com.quhaodian.haodian.data.service.EventInfoCategoryService;

public class EventInfoCatalogApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventInfoCategoryService service=ObjectFactory.get().getBean(EventInfoCategoryService.class);
		EventInfoCategory bean=new EventInfoCategory();
		service.save(bean);
	}

}
