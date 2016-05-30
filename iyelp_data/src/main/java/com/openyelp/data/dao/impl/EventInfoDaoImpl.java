package com.openyelp.data.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.BaseDaoImpl;
import com.ada.data.core.Pagination;
import com.openyelp.data.dao.EventInfoDao;
import com.openyelp.data.entity.EventInfo;

@Repository
public class EventInfoDaoImpl extends BaseDaoImpl<EventInfo, Long> implements EventInfoDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public EventInfo findById(Long id) {
		EventInfo entity = get(id);
		return entity;
	}

	public EventInfo save(EventInfo bean) {
		getSession().save(bean);
		return bean;
	}

	public EventInfo deleteById(Long id) {
		EventInfo entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<EventInfo> getEntityClass() {
		return EventInfo.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}