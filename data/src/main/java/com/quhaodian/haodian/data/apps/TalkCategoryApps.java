package com.quhaodian.haodian.data.apps;

import com.quhaodian.haodian.data.entity.TalkCategory;
import com.quhaodian.haodian.data.service.TalkCategoryService;

public class TalkCategoryApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TalkCategoryService service=ObjectFactory.get().getBean(TalkCategoryService.class);
		
		TalkCategory t=new TalkCategory();
		t.setName("讨论分类");
		service.save(t);
	}

}