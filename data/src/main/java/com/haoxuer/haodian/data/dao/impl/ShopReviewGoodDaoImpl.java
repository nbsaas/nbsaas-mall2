package com.haoxuer.haodian.data.dao.impl;

import com.haoxuer.haodian.data.entity.ShopReviewGood;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.BaseDaoImpl;
import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.haodian.data.dao.ShopReviewGoodDao;

@Repository
public class ShopReviewGoodDaoImpl extends BaseDaoImpl<ShopReviewGood, Long> implements ShopReviewGoodDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public ShopReviewGood findById(Long id) {
		ShopReviewGood entity = get(id);
		return entity;
	}

	public ShopReviewGood save(ShopReviewGood bean) {
		getSession().save(bean);
		return bean;
	}

	public ShopReviewGood deleteById(Long id) {
		ShopReviewGood entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ShopReviewGood> getEntityClass() {
		return ShopReviewGood.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}