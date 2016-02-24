package com.openyelp.core.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.openyelp.core.dao.SiteDao;
import com.openyelp.core.entity.Site;
import com.openyelp.data.core.BaseDaoImpl;
import com.openyelp.data.core.Pagination;

@Repository
public class SiteDaoImpl extends BaseDaoImpl<Site, Integer> implements SiteDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public Site findById(Integer id) {
		Site entity = get(id);
		return entity;
	}

	public Site save(Site bean) {
		getSession().save(bean);
		return bean;
	}

	public Site deleteById(Integer id) {
		Site entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Site> getEntityClass() {
		return Site.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}