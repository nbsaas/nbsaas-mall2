package com.openyelp.data.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.openyelp.data.core.BaseDaoImpl;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.dao.EventInfoJoinDao;
import com.openyelp.data.entity.EventInfoJoin;

@Repository
public class EventInfoJoinDaoImpl extends BaseDaoImpl<EventInfoJoin, Long> implements EventInfoJoinDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public EventInfoJoin findById(Long id) {
		EventInfoJoin entity = get(id);
		return entity;
	}

	public EventInfoJoin save(EventInfoJoin bean) {
		getSession().save(bean);
		return bean;
	}

	public EventInfoJoin deleteById(Long id) {
		EventInfoJoin entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<EventInfoJoin> getEntityClass() {
		return EventInfoJoin.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}