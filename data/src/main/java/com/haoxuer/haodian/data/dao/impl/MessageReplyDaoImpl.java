package com.haoxuer.haodian.data.dao.impl;

import com.haoxuer.haodian.data.entity.MessageReply;
import com.haoxuer.haodian.data.dao.MessageReplyDao;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.BaseDaoImpl;
import com.haoxuer.discover.data.core.Pagination;

@Repository
public class MessageReplyDaoImpl extends BaseDaoImpl<MessageReply, Long> implements MessageReplyDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public MessageReply findById(Long id) {
		MessageReply entity = get(id);
		return entity;
	}

	public MessageReply save(MessageReply bean) {
		getSession().save(bean);
		return bean;
	}

	public MessageReply deleteById(Long id) {
		MessageReply entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<MessageReply> getEntityClass() {
		return MessageReply.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}