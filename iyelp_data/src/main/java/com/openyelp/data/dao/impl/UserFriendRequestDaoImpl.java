package com.openyelp.data.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.openyelp.data.core.BaseDaoImpl;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.dao.UserFriendRequestDao;
import com.openyelp.data.entity.UserFriendRequest;

@Repository
public class UserFriendRequestDaoImpl extends BaseDaoImpl<UserFriendRequest, Long> implements UserFriendRequestDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public UserFriendRequest findById(Long id) {
		UserFriendRequest entity = get(id);
		return entity;
	}

	public UserFriendRequest save(UserFriendRequest bean) {
		getSession().save(bean);
		return bean;
	}

	public UserFriendRequest deleteById(Long id) {
		UserFriendRequest entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserFriendRequest> getEntityClass() {
		return UserFriendRequest.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}