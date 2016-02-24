package com.ada.iyelp.apps;

import com.openyelp.data.entity.ShopCheckIn;
import com.openyelp.data.entity.ShopImageList;
import com.openyelp.data.service.ShopCheckInService;
import com.openyelp.data.service.ShopImageListService;

public class ShopCheckinServiceApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShopCheckInService userService = ObjectFactory.get().getBean(
				ShopCheckInService.class);
		ShopCheckIn list=	userService.findById(1l);
		System.out.println(list);
	}

}
