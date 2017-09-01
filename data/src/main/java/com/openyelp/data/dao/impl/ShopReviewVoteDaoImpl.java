package com.openyelp.data.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.BaseDaoImpl;
import com.ada.data.core.Pagination;
import com.openyelp.data.dao.ShopReviewVoteDao;
import com.openyelp.data.entity.ShopReviewVote;

@Repository
public class ShopReviewVoteDaoImpl extends BaseDaoImpl<ShopReviewVote, Long> implements ShopReviewVoteDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public ShopReviewVote findById(Long id) {
		ShopReviewVote entity = get(id);
		return entity;
	}

	public ShopReviewVote save(ShopReviewVote bean) {
		getSession().save(bean);
		return bean;
	}

	public ShopReviewVote deleteById(Long id) {
		ShopReviewVote entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ShopReviewVote> getEntityClass() {
		return ShopReviewVote.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}