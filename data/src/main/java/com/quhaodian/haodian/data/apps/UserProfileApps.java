package com.quhaodian.haodian.data.apps;

import com.quhaodian.user.data.entity.UserInfo;
import com.quhaodian.haodian.data.entity.UserProfile;
import com.quhaodian.haodian.data.service.UserProfileService;

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
