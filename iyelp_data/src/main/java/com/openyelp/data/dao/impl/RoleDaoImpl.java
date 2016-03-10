package com.openyelp.data.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.BaseDaoImpl;
import com.ada.data.core.Pagination;
import com.openyelp.data.dao.RoleDao;
import com.openyelp.data.entity.UserRole;

@Repository
public class RoleDaoImpl extends BaseDaoImpl<UserRole, Long> implements RoleDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public UserRole findById(Long id) {
		UserRole entity = get(id);
		return entity;
	}

	public UserRole save(UserRole bean) {
		getSession().save(bean);
		return bean;
	}

	public UserRole deleteById(Long id) {
		UserRole entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserRole> getEntityClass() {
		return UserRole.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}