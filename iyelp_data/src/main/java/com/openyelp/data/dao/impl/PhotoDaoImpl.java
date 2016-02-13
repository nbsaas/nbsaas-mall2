package com.openyelp.data.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.openyelp.data.core.BaseDaoImpl;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.dao.PhotoDao;
import com.openyelp.data.entity.Photo;

@Repository
public class PhotoDaoImpl extends BaseDaoImpl<Photo, Long> implements PhotoDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public Photo findById(Long id) {
		Photo entity = get(id);
		return entity;
	}

	public Photo save(Photo bean) {
		getSession().save(bean);
		return bean;
	}

	public Photo deleteById(Long id) {
		Photo entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Photo> getEntityClass() {
		return Photo.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}