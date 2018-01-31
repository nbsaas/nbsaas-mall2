package com.quhaodian.data.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.BaseDaoImpl;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dao.EventInfoPhotoDao;
import com.quhaodian.data.entity.EventInfoPhoto;

@Repository
public class EventInfoPhotoDaoImpl extends BaseDaoImpl<EventInfoPhoto, Long> implements EventInfoPhotoDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public EventInfoPhoto findById(Long id) {
		EventInfoPhoto entity = get(id);
		return entity;
	}

	public EventInfoPhoto save(EventInfoPhoto bean) {
		getSession().save(bean);
		return bean;
	}

	public EventInfoPhoto deleteById(Long id) {
		EventInfoPhoto entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<EventInfoPhoto> getEntityClass() {
		return EventInfoPhoto.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}