package com.haoxuer.haodian.data.dao.impl;

import com.haoxuer.haodian.data.entity.EventInfo;
import com.haoxuer.haodian.data.dao.EventInfoDao;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.BaseDaoImpl;
import com.haoxuer.discover.data.core.Pagination;

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