package com.openyelp.data.apps;

import java.util.List;

import com.openyelp.data.core.Pagination;
import com.openyelp.data.entity.ShopReviewGood;
import com.openyelp.data.service.ShopReviewGoodService;

public class ShopReviewGoodServiceApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShopReviewGoodService s = ObjectFactory.get().getBean(
				ShopReviewGoodService.class);
		;
		Pagination page = s.pageByArea(111, 1, 10);
		List<ShopReviewGood> ls = page.getList();
		for (ShopReviewGood shopReviewGood : ls) {
			System.out.println(shopReviewGood);
		}
	}

}
