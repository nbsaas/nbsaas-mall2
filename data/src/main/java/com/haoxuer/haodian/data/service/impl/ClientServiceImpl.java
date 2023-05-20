package com.haoxuer.haodian.data.service.impl;

import java.util.List;

import com.haoxuer.haodian.data.dao.ClientDao;
import com.haoxuer.haodian.data.entity.Client;
import com.haoxuer.haodian.data.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.discover.data.core.Updater;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public Client findById(Integer id) {
		Client entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public Client save(Client bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public Client update(Client bean) {
		Updater<Client> updater = new Updater<Client>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public Client deleteById(Integer id) {
		Client bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public Client[] deleteByIds(Integer[] ids) {
		Client[] beans = new Client[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private ClientDao dao;

	@Autowired
	public void setDao(ClientDao dao) {
		this.dao = dao;
	}

	@Override
	public Client findById(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client findByClientId(String clientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client findByClientSecret(String clientSecret) {
		// TODO Auto-generated method stub
		return null;
	}
}