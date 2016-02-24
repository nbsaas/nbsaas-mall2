package com.openyelp.data.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.openyelp.data.core.BaseDaoImpl;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.dao.NotificationDao;
import com.openyelp.data.entity.Notification;

@Repository
public class NotificationDaoImpl extends BaseDaoImpl<Notification, Long> implements NotificationDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public Notification findById(Long id) {
		Notification entity = get(id);
		return entity;
	}

	public Notification save(Notification bean) {
		getSession().save(bean);
		return bean;
	}

	public Notification deleteById(Long id) {
		Notification entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Notification> getEntityClass() {
		return Notification.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}