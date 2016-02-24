package com.openyelp.data.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.openyelp.data.core.BaseDaoImpl;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.dao.UserDao;
import com.openyelp.data.entity.UserInfo;

@Repository
public class UserDaoImpl extends BaseDaoImpl<UserInfo, Long> implements UserDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public UserInfo findById(Long id) {
		UserInfo entity = get(id);
		return entity;
	}

	public UserInfo save(UserInfo bean) {
		getSession().save(bean);
		return bean;
	}

	public UserInfo deleteById(Long id) {
		UserInfo entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserInfo> getEntityClass() {
		return UserInfo.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}