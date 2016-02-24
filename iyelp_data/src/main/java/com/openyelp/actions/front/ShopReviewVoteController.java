package com.openyelp.actions.front;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.openyelp.data.entity.ShopReview;
import com.openyelp.data.entity.ShopReviewVote;
import com.openyelp.data.service.ShopReviewVoteService;
import com.openyelp.shiro.utils.UserUtil;

@Controller
public class ShopReviewVoteController {

	@Autowired
	ShopReviewVoteService voteService;

	
	@RequestMapping(value = "shopreviewvote", method = RequestMethod.GET)
	@RequiresAuthentication
	@ResponseBody
	public int vote(ShopReviewVote bean,long reviewid) {
		int result=-1;
		ShopReview review=new ShopReview();
		review.setId(reviewid);
		bean.setReview(review);
		bean.setUser(UserUtil.getCurrentUser());
		result = voteService.vote(bean);
		return result;
	}

}
