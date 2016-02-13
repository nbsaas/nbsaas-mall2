package com.openyelp.data.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.openyelp.data.core.BaseDaoImpl;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.dao.ShopImageDao;
import com.openyelp.data.entity.ShopImage;

@Repository
public class ShopImageDaoImpl extends BaseDaoImpl<ShopImage, Long> implements ShopImageDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public ShopImage findById(Long id) {
		ShopImage entity = get(id);
		return entity;
	}

	public ShopImage save(ShopImage bean) {
		getSession().save(bean);
		return bean;
	}

	public ShopImage deleteById(Long id) {
		ShopImage entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ShopImage> getEntityClass() {
		return ShopImage.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}