package com.openyelp.data.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.BaseDaoImpl;
import com.ada.data.core.Pagination;
import com.openyelp.data.dao.AreaHotDao;
import com.openyelp.data.entity.AreaHot;

@Repository
public class AreaHotDaoImpl extends BaseDaoImpl<AreaHot, Integer> implements AreaHotDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public AreaHot findById(Integer id) {
		AreaHot entity = get(id);
		return entity;
	}

	public AreaHot save(AreaHot bean) {
		getSession().save(bean);
		return bean;
	}

	public AreaHot deleteById(Integer id) {
		AreaHot entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<AreaHot> getEntityClass() {
		return AreaHot.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}