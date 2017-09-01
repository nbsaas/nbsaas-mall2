package com.openyelp.data.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.BaseDaoImpl;
import com.ada.data.core.Pagination;
import com.openyelp.data.dao.ShopTagDao;
import com.openyelp.data.entity.ShopTag;

@Repository
public class ShopTagDaoImpl extends BaseDaoImpl<ShopTag, Long> implements ShopTagDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public ShopTag findById(Long id) {
		ShopTag entity = get(id);
		return entity;
	}

	public ShopTag save(ShopTag bean) {
		getSession().save(bean);
		return bean;
	}

	public ShopTag deleteById(Long id) {
		ShopTag entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ShopTag> getEntityClass() {
		return ShopTag.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}