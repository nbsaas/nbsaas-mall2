package com.quhaodian.haodian.data.apps;

import com.quhaodian.haodian.data.entity.ContentCount;
import com.quhaodian.haodian.data.service.ContentCountService;
import com.quhaodian.haodian.data.service.ContentService;
import com.quhaodian.haodian.data.entity.Content;

public class ContentApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContentService userService = ObjectFactory.get().getBean(
				ContentService.class);
		ContentCountService contentCountService = ObjectFactory.get().getBean(
				ContentCountService.class);
		
		Content conten=new Content();
		conten.setTitle("gg");
		
		ContentCount count=new ContentCount();
		count.init();
		contentCountService.save(count);
		conten.setContentCount(count);
		conten.addTag("测试");
		conten.addTag("测试");
		conten.addTag("测试");
		conten.addTag("测试");
		conten.addTag("测试1");
		conten.addTag("测试2");
		conten.addTag("测试3");

		userService.save(conten);
		
		conten=userService.findById(3);
		System.out.println(conten);
		count=contentCountService.findById(2);
		System.out.println(count);
	}

}