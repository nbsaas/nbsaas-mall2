package com.quhaodian.data.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.BaseDaoImpl;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dao.ContentCountDao;
import com.quhaodian.data.entity.ContentCount;

@Repository
public class ContentCountDaoImpl extends BaseDaoImpl<ContentCount, Integer> implements ContentCountDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public ContentCount findById(Integer id) {
		ContentCount entity = get(id);
		return entity;
	}

	public ContentCount save(ContentCount bean) {
		getSession().save(bean);
		return bean;
	}

	public ContentCount deleteById(Integer id) {
		ContentCount entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ContentCount> getEntityClass() {
		return ContentCount.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}