package com.quhaodian.haodian.data.dao.impl;

import com.quhaodian.haodian.data.entity.Channel;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.BaseDaoImpl;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.haodian.data.dao.ChannelDao;

@Repository
public class ChannelDaoImpl extends BaseDaoImpl<Channel, Integer> implements ChannelDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public Channel findById(Integer id) {
		Channel entity = get(id);
		return entity;
	}

	public Channel save(Channel bean) {
		getSession().save(bean);
		return bean;
	}

	public Channel deleteById(Integer id) {
		Channel entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Channel> getEntityClass() {
		return Channel.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}