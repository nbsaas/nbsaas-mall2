package com.openyelp.data.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.openyelp.data.core.BaseDaoImpl;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.dao.UserProfileDao;
import com.openyelp.data.entity.UserProfile;

@Repository
public class UserProfileDaoImpl extends BaseDaoImpl<UserProfile, Long> implements UserProfileDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public UserProfile findById(Long id) {
		UserProfile entity = get(id);
		return entity;
	}

	public UserProfile save(UserProfile bean) {
		getSession().save(bean);
		return bean;
	}

	public UserProfile deleteById(Long id) {
		UserProfile entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserProfile> getEntityClass() {
		return UserProfile.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}