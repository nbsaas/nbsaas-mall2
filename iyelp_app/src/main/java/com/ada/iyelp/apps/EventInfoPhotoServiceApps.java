package com.ada.iyelp.apps;

import com.ada.user.entity.UserInfo;
import com.openyelp.data.entity.EventInfo;
import com.openyelp.data.entity.EventInfoPhoto;
import com.openyelp.data.service.EventInfoPhotoService;

public class EventInfoPhotoServiceApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventInfoPhotoService service = ObjectFactory.get().getBean(
				EventInfoPhotoService.class);
		EventInfoPhoto bean=new EventInfoPhoto();;
		UserInfo userInfo=new UserInfo();
		userInfo.setId(2l);
		bean.setUser(userInfo);
		EventInfo eventinfo=new EventInfo();
		eventinfo.setId(8l);
		bean.setEventinfo(eventinfo);
		service.save(bean);
	}

}
