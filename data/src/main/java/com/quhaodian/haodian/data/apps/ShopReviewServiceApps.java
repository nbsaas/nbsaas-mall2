package com.quhaodian.haodian.data.apps;

import com.quhaodian.user.data.entity.UserInfo;
import com.quhaodian.haodian.data.entity.Shop;
import com.quhaodian.haodian.data.entity.ShopReview;
import com.quhaodian.haodian.data.service.ShopReviewService;

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