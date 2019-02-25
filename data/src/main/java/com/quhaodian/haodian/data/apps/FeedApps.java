package com.quhaodian.haodian.data.apps;

import java.util.List;

import com.quhaodian.haodian.data.service.FeedService;
import com.haoxuer.discover.data.core.Pagination;
import com.quhaodian.haodian.data.entity.Feed;

public class FeedApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		follows();
	}

	private static void friends() {
		FeedService feedService=ObjectFactory.get().getBean(FeedService.class);
		Pagination<Feed> fs=feedService.pageByFriend(2l, 1, 10);
		printfeeds(fs);
	}

	private static void follows() {
		FeedService feedService=ObjectFactory.get().getBean(FeedService.class);
		Pagination<Feed> fs=feedService.pageByFollow(2l, 1, 10);
		printfeeds(fs);
	}

	private static void printfeeds(Pagination<Feed> fs) {
		List<Feed> feeds= fs.getList();
		for (Feed feed : feeds) {
			System.out.println(feed);
		}
	}

	private static void feeds() {
		FeedService feedService=ObjectFactory.get().getBean(FeedService.class);
		
		Pagination<Feed> fs=	feedService.pageByArea(111, 1, 10);
		printfeeds(fs);
	}

}
