package com.quhaodian.data.apps;

import java.util.List;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.entity.ShopReviewGood;
import com.quhaodian.data.service.ShopReviewGoodService;

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
