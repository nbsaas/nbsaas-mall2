package com.openyelp.data.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.BaseDaoImpl;
import com.ada.data.core.Pagination;
import com.openyelp.data.dao.EventInfoCommentDao;
import com.openyelp.data.entity.EventInfoComment;

@Repository
public class EventInfoCommentDaoImpl extends BaseDaoImpl<EventInfoComment, Long> implements EventInfoCommentDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public EventInfoComment findById(Long id) {
		EventInfoComment entity = get(id);
		return entity;
	}

	public EventInfoComment save(EventInfoComment bean) {
		getSession().save(bean);
		return bean;
	}

	public EventInfoComment deleteById(Long id) {
		EventInfoComment entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<EventInfoComment> getEntityClass() {
		return EventInfoComment.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}