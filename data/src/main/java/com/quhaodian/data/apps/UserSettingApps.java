package com.quhaodian.data.apps;

import com.quhaodian.data.entity.UserSetting;
import com.quhaodian.data.service.UserSettingService;

public class UserSettingApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserSettingService service = ObjectFactory.get().getBean(
				UserSettingService.class);
		UserSetting set = service.findByUser(3l);
		System.out.println(set);
		System.out.println(set.getUser().getId());
	}

}
