package com.ada.iyelp.apps;

import java.util.List;

import com.openyelp.data.core.Pagination;
import com.openyelp.data.entity.Talk;
import com.openyelp.data.service.TalkService;

public class TalkApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TalkService service = ObjectFactory.get().getBean(TalkService.class);
//		Pagination page=	service.findByCity(100,12, 1, 10);
//		List<Talk> ts=	(List<Talk>) page.getList();
//		for (Talk talk : ts) {
//			System.out.println(talk);
//		}
		add();
	}

	private static void add() {
		TalkService service = ObjectFactory.get().getBean(TalkService.class);
		Talk talk=new Talk();
		talk.setMessage("ss");
		talk.setTopic("a");
		for (int i = 1; i <140000; i++) {
			talk=	service.add(talk, 5, "西安");
              System.out.println(talk);
		}
	}

}
