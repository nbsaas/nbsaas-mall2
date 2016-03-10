package com.ada.iyelp.apps;

import java.util.List;

import com.ada.data.core.Pagination;
import com.openyelp.data.entity.ShopImage;
import com.openyelp.data.service.ShopImageService;

public class ShopImageServiceApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShopImageService userService = ObjectFactory.get().getBean(
				ShopImageService.class);
		Pagination page = userService.page(111, 1, 1, 10);
		List<ShopImage> ls = (List<ShopImage>) page.getList();
		for (ShopImage shopReview : ls) {
			System.out.println(shopReview);
		}
		System.out.println(page);
	}

}
