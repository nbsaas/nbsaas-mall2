package com.openyelp.data.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.BaseDaoImpl;
import com.ada.data.core.Pagination;
import com.openyelp.data.dao.ShopCheckInDao;
import com.openyelp.data.entity.ShopCheckIn;

@Repository
public class ShopCheckInDaoImpl extends BaseDaoImpl<ShopCheckIn, Long> implements ShopCheckInDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public ShopCheckIn findById(Long id) {
		ShopCheckIn entity = get(id);
		return entity;
	}

	public ShopCheckIn save(ShopCheckIn bean) {
		getSession().save(bean);
		return bean;
	}

	public ShopCheckIn deleteById(Long id) {
		ShopCheckIn entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ShopCheckIn> getEntityClass() {
		return ShopCheckIn.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}