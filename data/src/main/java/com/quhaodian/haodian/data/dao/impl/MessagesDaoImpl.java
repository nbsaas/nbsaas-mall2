package com.quhaodian.haodian.data.dao.impl;

import com.quhaodian.haodian.data.dao.MessagesDao;
import com.quhaodian.haodian.data.entity.Messages;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.BaseDaoImpl;
import com.haoxuer.discover.data.core.Pagination;

@Repository
public class MessagesDaoImpl extends BaseDaoImpl<Messages, Long> implements MessagesDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public Messages findById(Long id) {
		Messages entity = get(id);
		return entity;
	}

	public Messages save(Messages bean) {
		getSession().save(bean);
		return bean;
	}

	public Messages deleteById(Long id) {
		Messages entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Messages> getEntityClass() {
		return Messages.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}