package com.quhaodian.data.dao.impl;

import com.quhaodian.data.dao.EntityContentDao;
import com.quhaodian.data.entity.EntityContent;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.BaseDaoImpl;
import com.quhaodian.data.core.Pagination;

@Repository
public class EntityContentDaoImpl extends BaseDaoImpl<EntityContent, Integer> implements EntityContentDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public EntityContent findById(Integer id) {
		EntityContent entity = get(id);
		return entity;
	}

	public EntityContent save(EntityContent bean) {
		getSession().save(bean);
		return bean;
	}

	public EntityContent deleteById(Integer id) {
		EntityContent entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<EntityContent> getEntityClass() {
		return EntityContent.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}