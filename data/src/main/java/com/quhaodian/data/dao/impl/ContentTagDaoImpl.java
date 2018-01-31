package com.quhaodian.data.dao.impl;

import com.quhaodian.data.dao.ContentTagDao;
import com.quhaodian.data.entity.ContentTag;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.BaseDaoImpl;
import com.quhaodian.data.core.Pagination;

@Repository
public class ContentTagDaoImpl extends BaseDaoImpl<ContentTag, Integer> implements ContentTagDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public ContentTag findById(Integer id) {
		ContentTag entity = get(id);
		return entity;
	}

	public ContentTag save(ContentTag bean) {
		getSession().save(bean);
		return bean;
	}

	public ContentTag deleteById(Integer id) {
		ContentTag entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ContentTag> getEntityClass() {
		return ContentTag.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}