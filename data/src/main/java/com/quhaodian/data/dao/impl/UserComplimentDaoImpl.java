package com.quhaodian.data.dao.impl;

import com.quhaodian.data.dao.UserComplimentDao;
import com.quhaodian.data.entity.UserCompliment;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.BaseDaoImpl;
import com.quhaodian.data.core.Pagination;

@Repository
public class UserComplimentDaoImpl extends BaseDaoImpl<UserCompliment, Long> implements UserComplimentDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public UserCompliment findById(Long id) {
		UserCompliment entity = get(id);
		return entity;
	}

	public UserCompliment save(UserCompliment bean) {
		getSession().save(bean);
		return bean;
	}

	public UserCompliment deleteById(Long id) {
		UserCompliment entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserCompliment> getEntityClass() {
		return UserCompliment.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}