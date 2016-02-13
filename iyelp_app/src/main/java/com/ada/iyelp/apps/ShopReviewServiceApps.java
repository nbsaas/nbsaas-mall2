package com.ada.iyelp.apps;

import java.util.List;

import com.openyelp.data.core.Pagination;
import com.openyelp.data.entity.Shop;
import com.openyelp.data.entity.ShopReview;
import com.openyelp.data.entity.UserInfo;
import com.openyelp.data.service.ShopReviewService;

public class ShopReviewServiceApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShopReviewService userService = ObjectFactory.get().getBean(
				ShopReviewService.class);
		//userService.deleteById(41l);
		//System.out.println(page);

		ShopReview review=new ShopReview();
		UserInfo user=new UserInfo();
		user.setId(14l);
		review.setUser(user);
		review.setServicescore(5);
		Shop shop=new Shop();
		shop.setId(3513l);
		review.setShop(shop);
		userService.save(review);
	}

}
