package com.ada.iyelp.apps;

import com.ada.user.entity.UserInfo;
import com.quhaodian.data.entity.EventInfo;
import com.quhaodian.data.entity.EventInfoPhoto;
import com.quhaodian.data.service.EventInfoPhotoService;

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
