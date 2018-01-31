package com.quhaodian.haodian.actions.front;

import com.quhaodian.haodian.data.entity.ShopReview;
import com.quhaodian.haodian.data.entity.ShopReviewVote;
import com.quhaodian.haodian.data.service.ShopReviewVoteService;
import com.quhaodian.haodian.shiro.utils.UserUtil;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShopReviewVoteController {

	@Autowired
    ShopReviewVoteService voteService;

	
	@RequestMapping(value = "shopreviewvote", method = RequestMethod.GET)
	@RequiresAuthentication
	@ResponseBody
	public int vote(ShopReviewVote bean, long reviewid) {
		int result=-1;
		ShopReview review=new ShopReview();
		review.setId(reviewid);
		bean.setReview(review);
		bean.setUser(UserUtil.getCurrentUser());
		result = voteService.vote(bean);
		return result;
	}

}
