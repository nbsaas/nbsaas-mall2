package com.quhaodian.haodian.data.dao.impl;

import com.quhaodian.haodian.data.dao.TalkReplyDao;
import com.quhaodian.haodian.data.entity.TalkReply;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.CriteriaDaoImpl;
import com.haoxuer.discover.data.core.Pagination;

@Repository
public class TalkReplyDaoImpl extends CriteriaDaoImpl<TalkReply, Integer> implements TalkReplyDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public TalkReply findById(Integer id) {
		TalkReply entity = get(id);
		return entity;
	}

	public TalkReply save(TalkReply bean) {
		getSession().save(bean);
		return bean;
	}

	public TalkReply deleteById(Integer id) {
		TalkReply entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<TalkReply> getEntityClass() {
		return TalkReply.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}