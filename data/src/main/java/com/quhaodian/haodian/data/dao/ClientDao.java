package com.quhaodian.haodian.data.dao;


import com.quhaodian.haodian.data.entity.Client;
import com.quhaodian.data.core.BaseDao;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;

public interface ClientDao extends BaseDao<Client, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public Client findById(Integer id);

	public Client save(Client bean);

	public Client updateByUpdater(Updater<Client> updater);

	public Client deleteById(Integer id);
}