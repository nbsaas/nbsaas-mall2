package com.quhaodian.data.dao.impl;

import com.quhaodian.data.dao.PhotoDao;
import com.quhaodian.data.entity.Photo;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.BaseDaoImpl;
import com.ada.data.core.Pagination;

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