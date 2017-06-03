package com.quhaodian.data.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.quhaodian.data.entity.TalkCategory;

public class TalkCategoryPage extends PageRpc<TalkCategory> {

	public TalkCategoryPage(Pagination<TalkCategory> page) {
		super(page);
	}

}
