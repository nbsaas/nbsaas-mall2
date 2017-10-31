package com.quhaodian.data.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.BaseDaoImpl;
import com.ada.data.core.Pagination;
import com.quhaodian.data.dao.ShopBackDao;
import com.quhaodian.data.entity.ShopBack;

@Repository
public class ShopBackDaoImpl extends BaseDaoImpl<ShopBack, Long> implements ShopBackDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public ShopBack findById(Long id) {
		ShopBack entity = get(id);
		return entity;
	}

	public ShopBack save(ShopBack bean) {
		getSession().save(bean);
		return bean;
	}

	public ShopBack deleteById(Long id) {
		ShopBack entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ShopBack> getEntityClass() {
		return ShopBack.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}