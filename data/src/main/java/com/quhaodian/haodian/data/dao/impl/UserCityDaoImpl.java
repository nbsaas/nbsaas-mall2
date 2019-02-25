package com.quhaodian.haodian.data.dao.impl;

import com.quhaodian.haodian.data.dao.UserCityDao;
import com.quhaodian.haodian.data.entity.UserCity;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.BaseDaoImpl;
import com.haoxuer.discover.data.core.Pagination;

@Repository
public class UserCityDaoImpl extends BaseDaoImpl<UserCity, Long> implements UserCityDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public UserCity findById(Long id) {
		UserCity entity = get(id);
		return entity;
	}

	public UserCity save(UserCity bean) {
		getSession().save(bean);
		return bean;
	}

	public UserCity deleteById(Long id) {
		UserCity entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserCity> getEntityClass() {
		return UserCity.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}