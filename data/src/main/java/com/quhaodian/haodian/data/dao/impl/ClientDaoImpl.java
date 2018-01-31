package com.quhaodian.haodian.data.dao.impl;

import com.quhaodian.haodian.data.entity.Client;
import com.quhaodian.haodian.data.dao.ClientDao;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.BaseDaoImpl;
import com.quhaodian.data.core.Pagination;

@Repository
public class ClientDaoImpl extends BaseDaoImpl<Client, Integer> implements ClientDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public Client findById(Integer id) {
		Client entity = get(id);
		return entity;
	}

	public Client save(Client bean) {
		getSession().save(bean);
		return bean;
	}

	public Client deleteById(Integer id) {
		Client entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Client> getEntityClass() {
		return Client.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}