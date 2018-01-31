package com.quhaodian.haodian.data.apps;

import com.quhaodian.haodian.data.entity.ShopCheckIn;
import com.quhaodian.haodian.data.service.ShopCheckInService;

public class ShopCheckinServiceApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShopCheckInService userService = ObjectFactory.get().getBean(
				ShopCheckInService.class);
		ShopCheckIn list=	userService.findById(1l);
		System.out.println(list);
	}

}
