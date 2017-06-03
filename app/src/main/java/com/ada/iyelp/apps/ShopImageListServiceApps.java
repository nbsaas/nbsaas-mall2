package com.ada.iyelp.apps;

import com.quhaodian.data.entity.ShopImageList;
import com.quhaodian.data.service.ShopImageListService;

public class ShopImageListServiceApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShopImageListService userService = ObjectFactory.get().getBean(
				ShopImageListService.class);
		ShopImageList list=	userService.findById(1l);
		System.out.println(list);
	}

}
