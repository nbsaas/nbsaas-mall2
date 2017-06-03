package com.quhaodian.data.apps;

import com.ada.user.entity.UserInfo;
import com.quhaodian.data.entity.UserProfile;
import com.quhaodian.data.service.UserProfileService;

public class UserProfileApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserProfileService service = ObjectFactory.get().getBean(UserProfileService.class);
		UserInfo user=new UserInfo();
		
		user.setId(1l);
		UserProfile file=new UserProfile();
		file.setUser(user);
		file.setBlog("a");
		file.setBook("xx");
	    service.update(file);
	}

}
