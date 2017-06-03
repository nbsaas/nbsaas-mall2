package com.quhaodian.data.apps;

import com.quhaodian.data.entity.ShopCheckIn;
import com.quhaodian.data.service.ShopCheckInService;

public class ShopCheckinServiceApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShopCheckInService userService = ObjectFactory.get().getBean(
				ShopCheckInService.class);
		ShopCheckIn list=	userService.findById(1l);
		System.out.println(list);
	}

}
