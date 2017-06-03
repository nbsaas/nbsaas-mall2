package com.quhaodian.data.dao.impl;

import com.quhaodian.data.dao.ShopDao;
import com.quhaodian.data.entity.Shop;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.BaseDaoImpl;
import com.ada.data.core.Pagination;

@Repository
public class ShopDaoImpl extends BaseDaoImpl<Shop, Long> implements ShopDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public Shop findById(Long id) {
		Shop entity = get(id);
		return entity;
	}

	public Shop save(Shop bean) {
		getSession().save(bean);
		return bean;
	}

	public Shop deleteById(Long id) {
		Shop entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Shop> getEntityClass() {
		return Shop.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}