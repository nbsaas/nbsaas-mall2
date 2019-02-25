package com.quhaodian.haodian.data.dao.impl;

import com.quhaodian.haodian.data.dao.UserProfileDao;
import com.quhaodian.haodian.data.entity.UserProfile;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.BaseDaoImpl;
import com.haoxuer.discover.data.core.Pagination;

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