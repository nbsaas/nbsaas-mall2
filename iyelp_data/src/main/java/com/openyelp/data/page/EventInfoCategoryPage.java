package com.openyelp.data.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.openyelp.data.entity.EventInfoCategory;
public class EventInfoCategoryPage extends PageRpc<EventInfoCategory> {

	public EventInfoCategoryPage(Pagination<EventInfoCategory> page) {
		super(page);
	}

}