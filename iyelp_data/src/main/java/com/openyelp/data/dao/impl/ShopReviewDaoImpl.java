package com.openyelp.data.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.openyelp.data.core.BaseDaoImpl;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.dao.ShopReviewDao;
import com.openyelp.data.entity.ShopReview;

@Repository
public class ShopReviewDaoImpl extends BaseDaoImpl<ShopReview, Long> implements ShopReviewDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public ShopReview findById(Long id) {
		ShopReview entity = get(id);
		return entity;
	}

	public ShopReview save(ShopReview bean) {
		getSession().save(bean);
		return bean;
	}

	public ShopReview deleteById(Long id) {
		ShopReview entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ShopReview> getEntityClass() {
		return ShopReview.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}