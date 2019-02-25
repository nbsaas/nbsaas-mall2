package com.haoxuer.haodian.data.dao.impl;

import com.haoxuer.haodian.data.entity.TalkCategory;
import com.haoxuer.haodian.data.dao.TalkCategoryDao;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.discover.data.core.Pagination;

@Repository
public class TalkCategoryDaoImpl extends CriteriaDaoImpl<TalkCategory, Integer> implements TalkCategoryDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public TalkCategory findById(Integer id) {
		TalkCategory entity = get(id);
		return entity;
	}

	public TalkCategory save(TalkCategory bean) {
		getSession().save(bean);
		return bean;
	}

	public TalkCategory deleteById(Integer id) {
		TalkCategory entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<TalkCategory> getEntityClass() {
		return TalkCategory.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}