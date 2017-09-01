package com.quhaodian.data.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.BaseDaoImpl;
import com.ada.data.core.Pagination;
import com.quhaodian.data.dao.UserPointsDao;
import com.quhaodian.data.entity.UserPoints;

@Repository
public class UserPointsDaoImpl extends BaseDaoImpl<UserPoints, Long> implements UserPointsDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public UserPoints findById(Long id) {
		UserPoints entity = get(id);
		return entity;
	}

	public UserPoints save(UserPoints bean) {
		getSession().save(bean);
		return bean;
	}

	public UserPoints deleteById(Long id) {
		UserPoints entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserPoints> getEntityClass() {
		return UserPoints.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}