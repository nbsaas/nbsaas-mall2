package com.openyelp.data.dao;


import com.openyelp.data.core.BaseDao;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;
import com.openyelp.data.entity.Client;

public interface ClientDao extends BaseDao<Client, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public Client findById(Integer id);

	public Client save(Client bean);

	public Client updateByUpdater(Updater<Client> updater);

	public Client deleteById(Integer id);
}