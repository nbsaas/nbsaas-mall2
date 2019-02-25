package com.quhaodian.haodian.data.dao.impl;

import com.quhaodian.haodian.data.entity.ShopCheckIn;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.BaseDaoImpl;
import com.haoxuer.discover.data.core.Pagination;
import com.quhaodian.haodian.data.dao.ShopCheckInDao;

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