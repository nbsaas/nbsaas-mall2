package com.haoxuer.haodian.data.apps;

import java.util.List;

import com.haoxuer.haodian.data.entity.ShopReviewGood;
import com.haoxuer.haodian.data.service.ShopReviewGoodService;
import com.haoxuer.discover.data.core.Pagination;

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
