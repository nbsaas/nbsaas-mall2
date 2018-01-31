package com.quhaodian.haodian.data.apps;

import java.util.List;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.haodian.data.entity.Messages;
import com.quhaodian.haodian.data.service.MessagesService;

public class MesageApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MessagesService service = ObjectFactory.get().getBean(
				MessagesService.class);
		Pagination p = service.pageByReceive(1l, 1, 10);
		List<Messages> ms = (List<Messages>) p.getList();
		for (Messages messages : ms) {
			System.out.println(messages);
		}
	}

}
