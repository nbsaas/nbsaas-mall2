package com.quhaodian.data.dao.impl;

import java.util.Date;

import com.quhaodian.data.dao.ShopDao;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.BaseDaoImpl;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dao.FeedDao;
import com.quhaodian.data.dao.ShopReviewDao;
import com.quhaodian.data.entity.EventInfo;
import com.quhaodian.data.entity.Feed;
import com.quhaodian.data.entity.Shop;
import com.quhaodian.data.entity.ShopImageList;
import com.quhaodian.data.entity.ShopReview;
import com.quhaodian.data.entity.Talk;

@Repository
public class FeedDaoImpl extends BaseDaoImpl<Feed, Long> implements FeedDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public Feed findById(Long id) {
		Feed entity = get(id);
		return entity;
	}

	public Feed save(Feed bean) {
		getSession().save(bean);
		return bean;
	}

	public Feed deleteById(Long id) {
		Feed entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	@Override
	protected Class<Feed> getEntityClass() {
		return Feed.class;
	}

	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Autowired
	ShopReviewDao reviewDao;

	
	@Autowired
    ShopDao shopDao;
	
	@CacheEvict(allEntries = true,value="feed_cache")
	@Override
	public Feed addFeed(Object bean) {
		Feed feed = new Feed();
		if (bean instanceof ShopReview) {
			ShopReview view = (ShopReview) bean;
			Shop shop=shopDao.findById(view.getShop().getId());
			feed.setAddDate(new Date());
			feed.setUser(view.getUser());
			feed.setOid(view.getId());
			feed.setNote(view.getComment());
			feed.setTitle("");
			feed.setCatalog(4);
			feed.setArea(shop.getArea());
		} else if (bean instanceof EventInfo) {
			EventInfo view = (EventInfo) bean;
			feed.setAddDate(new Date());
			feed.setUser(view.getUser());
			feed.setOid(view.getId());
			feed.setNote("");
			feed.setCatalog(2);
			feed.setTitle("");
			feed.setArea(view.getArea());
		} else if (bean instanceof Shop) {
			Shop view = (Shop) bean;
			feed.setAddDate(new Date());
			feed.setUser(view.getUser());
			feed.setOid(view.getId());
			feed.setNote("");
			feed.setTitle("");
			feed.setCatalog(1);
			feed.setArea(view.getArea());

		} else if (bean instanceof Talk) {
			Talk view = (Talk) bean;
			feed.setAddDate(new Date());
			feed.setUser(view.getUser());
			feed.setOid(view.getId());
			feed.setNote("");
			feed.setTitle("");
			feed.setCatalog(3);
			feed.setArea(view.getArea().getArea());
		}
		else if (bean instanceof ShopImageList) {
			ShopImageList view = (ShopImageList) bean;
			feed.setAddDate(new Date());
			feed.setUser(view.getUser());
			feed.setOid(view.getId());
			feed.setNote("");
			feed.setTitle("");
			feed.setCatalog(6);
			feed.setArea(view.getArea());
		}
		if (feed.getUser() == null) {
			return feed;
		}
		getSession().save(feed);
		return feed;
	}
}