package com.haoxuer.haodian.data.apps;

import com.haoxuer.haodian.data.entity.ShopImageList;
import com.haoxuer.haodian.data.service.ShopImageListService;

public class ShopImageListServiceApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShopImageListService userService = ObjectFactory.get().getBean(
				ShopImageListService.class);
		ShopImageList list=	userService.findById(1l);
		System.out.println(list);
	}

}
