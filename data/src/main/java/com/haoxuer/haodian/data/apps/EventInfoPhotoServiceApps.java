package com.haoxuer.haodian.data.apps;

import com.haoxuer.haodian.data.entity.EventInfo;
import com.haoxuer.haodian.data.entity.EventInfoPhoto;
import com.haoxuer.haodian.data.service.EventInfoPhotoService;
import com.haoxuer.discover.user.data.entity.UserInfo;

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
