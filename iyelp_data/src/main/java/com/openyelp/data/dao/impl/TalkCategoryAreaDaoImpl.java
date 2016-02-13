package com.openyelp.data.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.openyelp.data.core.BaseDaoImpl;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.dao.TalkCategoryAreaDao;
import com.openyelp.data.entity.TalkCategoryArea;

@Repository
public class TalkCategoryAreaDaoImpl extends BaseDaoImpl<TalkCategoryArea, Integer> implements TalkCategoryAreaDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public TalkCategoryArea findById(Integer id) {
		TalkCategoryArea entity = get(id);
		return entity;
	}

	public TalkCategoryArea save(TalkCategoryArea bean) {
		getSession().save(bean);
		return bean;
	}

	public TalkCategoryArea deleteById(Integer id) {
		TalkCategoryArea entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<TalkCategoryArea> getEntityClass() {
		return TalkCategoryArea.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}