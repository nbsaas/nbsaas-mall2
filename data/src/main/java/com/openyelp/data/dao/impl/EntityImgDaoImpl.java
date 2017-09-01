package com.openyelp.data.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.BaseDaoImpl;
import com.ada.data.core.Pagination;
import com.openyelp.data.dao.EntityImgDao;
import com.openyelp.data.entity.EntityImg;

@Repository
public class EntityImgDaoImpl extends BaseDaoImpl<EntityImg, Integer> implements EntityImgDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public EntityImg findById(Integer id) {
		EntityImg entity = get(id);
		return entity;
	}

	public EntityImg save(EntityImg bean) {
		getSession().save(bean);
		return bean;
	}

	public EntityImg deleteById(Integer id) {
		EntityImg entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<EntityImg> getEntityClass() {
		return EntityImg.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}