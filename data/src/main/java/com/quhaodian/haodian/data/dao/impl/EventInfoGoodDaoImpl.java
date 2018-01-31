package com.quhaodian.haodian.data.dao.impl;

import com.quhaodian.haodian.data.dao.EventInfoGoodDao;
import com.quhaodian.haodian.data.entity.EventInfoGood;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.BaseDaoImpl;
import com.quhaodian.data.core.Pagination;

@Repository
public class EventInfoGoodDaoImpl extends BaseDaoImpl<EventInfoGood, Long> implements EventInfoGoodDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public EventInfoGood findById(Long id) {
		EventInfoGood entity = get(id);
		return entity;
	}

	public EventInfoGood save(EventInfoGood bean) {
		getSession().save(bean);
		return bean;
	}

	public EventInfoGood deleteById(Long id) {
		EventInfoGood entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<EventInfoGood> getEntityClass() {
		return EventInfoGood.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}