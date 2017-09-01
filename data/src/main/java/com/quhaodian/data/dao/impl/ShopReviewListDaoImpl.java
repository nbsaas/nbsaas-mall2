package com.quhaodian.data.dao.impl;

import com.quhaodian.data.entity.ShopReviewList;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.BaseDaoImpl;
import com.ada.data.core.Pagination;
import com.quhaodian.data.dao.ShopReviewListDao;

@Repository
public class ShopReviewListDaoImpl extends BaseDaoImpl<ShopReviewList, Long> implements ShopReviewListDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public ShopReviewList findById(Long id) {
		ShopReviewList entity = get(id);
		return entity;
	}

	public ShopReviewList save(ShopReviewList bean) {
		getSession().save(bean);
		return bean;
	}

	public ShopReviewList deleteById(Long id) {
		ShopReviewList entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ShopReviewList> getEntityClass() {
		return ShopReviewList.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}