package com.quhaodian.haodian.data.apps;

import com.quhaodian.haodian.data.service.ShopImageListService;
import com.quhaodian.haodian.data.entity.ShopImageList;

public class ShopImageListServiceApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShopImageListService userService = ObjectFactory.get().getBean(
				ShopImageListService.class);
		ShopImageList list=	userService.findById(1l);
		System.out.println(list);
	}

}
