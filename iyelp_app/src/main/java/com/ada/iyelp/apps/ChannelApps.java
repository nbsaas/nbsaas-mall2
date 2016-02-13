package com.ada.iyelp.apps;

import java.util.Iterator;

import com.openyelp.data.entity.Channel;
import com.openyelp.data.service.ChannelService;

public class ChannelApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChannelService userService = ObjectFactory.get().getBean(
				ChannelService.class);
		long time=System.currentTimeMillis();
		Channel c=new 	Channel();
		Channel p=new 	Channel();
		p.setId(6);
		c.setParent(p);
		c.setName("adadd");
		for (int i = 0; i < 100; i++) {
			c.setName("adadd"+i);
			userService.save(c);

		}
		time=System.currentTimeMillis()-time;
		
		System.out.println(time);
	}

}
