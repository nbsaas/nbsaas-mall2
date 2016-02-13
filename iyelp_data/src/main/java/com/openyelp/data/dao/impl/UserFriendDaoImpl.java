package com.openyelp.data.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.openyelp.data.core.BaseDaoImpl;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.dao.UserFriendDao;
import com.openyelp.data.entity.UserFriend;

@Repository
public class UserFriendDaoImpl extends BaseDaoImpl<UserFriend, Long> implements UserFriendDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public UserFriend findById(Long id) {
		UserFriend entity = get(id);
		return entity;
	}

	public UserFriend save(UserFriend bean) {
		getSession().save(bean);
		return bean;
	}

	public UserFriend deleteById(Long id) {
		UserFriend entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserFriend> getEntityClass() {
		return UserFriend.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}