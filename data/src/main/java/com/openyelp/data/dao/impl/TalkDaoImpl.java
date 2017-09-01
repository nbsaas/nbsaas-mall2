package com.openyelp.data.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.BaseDaoImpl;
import com.ada.data.core.Pagination;
import com.openyelp.data.dao.TalkDao;
import com.openyelp.data.entity.Talk;

@Repository
public class TalkDaoImpl extends BaseDaoImpl<Talk, Long> implements TalkDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public Talk findById(Long id) {
		Talk entity = get(id);
		return entity;
	}

	public Talk save(Talk bean) {
		getSession().save(bean);
		return bean;
	}

	public Talk deleteById(Long id) {
		Talk entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Talk> getEntityClass() {
		return Talk.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}