package com.ada.iyelp.apps;

import java.util.List;

import com.ada.data.core.Pagination;
import com.openyelp.data.entity.ShopImage;
import com.openyelp.data.entity.ShopImageList;
import com.openyelp.data.service.ShopImageListService;

public class ShopImageListServiceApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShopImageListService userService = ObjectFactory.get().getBean(
				ShopImageListService.class);
		ShopImageList list=	userService.findById(1l);
		System.out.println(list);
	}

}
