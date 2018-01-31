package com.quhaodian.data.dao;


import com.quhaodian.data.core.BaseDao;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.quhaodian.data.entity.Client;

public interface ClientDao extends BaseDao<Client, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public Client findById(Integer id);

	public Client save(Client bean);

	public Client updateByUpdater(Updater<Client> updater);

	public Client deleteById(Integer id);
}