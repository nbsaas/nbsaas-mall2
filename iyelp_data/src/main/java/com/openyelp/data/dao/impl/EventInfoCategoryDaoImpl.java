package com.openyelp.data.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.openyelp.data.core.BaseDaoImpl;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.dao.EventInfoCategoryDao;
import com.openyelp.data.entity.EventInfoCategory;

@Repository
public class EventInfoCategoryDaoImpl extends BaseDaoImpl<EventInfoCategory, Integer> implements EventInfoCategoryDao {
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