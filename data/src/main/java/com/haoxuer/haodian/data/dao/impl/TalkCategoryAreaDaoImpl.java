package com.haoxuer.haodian.data.dao.impl;

import com.haoxuer.haodian.data.entity.TalkCategoryArea;
import com.haoxuer.haodian.data.dao.TalkCategoryAreaDao;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.BaseDaoImpl;
import com.haoxuer.discover.data.core.Pagination;

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