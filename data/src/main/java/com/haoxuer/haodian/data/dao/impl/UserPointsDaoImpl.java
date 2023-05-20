package com.haoxuer.haodian.data.dao.impl;

import com.haoxuer.haodian.data.entity.UserPoints;
import com.haoxuer.haodian.data.dao.UserPointsDao;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.BaseDaoImpl;
import com.haoxuer.discover.data.core.Pagination;

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