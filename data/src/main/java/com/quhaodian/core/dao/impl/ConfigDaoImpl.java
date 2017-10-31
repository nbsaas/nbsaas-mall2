package com.quhaodian.core.dao.impl;

import com.quhaodian.core.dao.ConfigDao;
import com.quhaodian.core.entity.Config;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.BaseDaoImpl;
import com.ada.data.core.Pagination;

@Repository
public class ConfigDaoImpl extends BaseDaoImpl<Config, Integer> implements ConfigDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public Config findById(Integer id) {
		Config entity = get(id);
		return entity;
	}

	public Config save(Config bean) {
		getSession().save(bean);
		return bean;
	}

	public Config deleteById(Integer id) {
		Config entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Config> getEntityClass() {
		return Config.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}