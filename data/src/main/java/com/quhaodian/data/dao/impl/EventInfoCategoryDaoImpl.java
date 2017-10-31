package com.quhaodian.data.dao.impl;

import com.quhaodian.data.dao.EventInfoCategoryDao;
import com.quhaodian.data.entity.EventInfoCategory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.CriteriaDaoImpl;
import com.ada.data.core.Pagination;

@Repository
public class EventInfoCategoryDaoImpl extends CriteriaDaoImpl<EventInfoCategory, Integer> implements EventInfoCategoryDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public EventInfoCategory findById(Integer id) {
		EventInfoCategory entity = get(id);
		return entity;
	}

	public EventInfoCategory save(EventInfoCategory bean) {
		getSession().save(bean);
		return bean;
	}

	public EventInfoCategory deleteById(Integer id) {
		EventInfoCategory entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<EventInfoCategory> getEntityClass() {
		return EventInfoCategory.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}