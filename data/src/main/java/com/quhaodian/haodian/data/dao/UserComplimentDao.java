package com.quhaodian.haodian.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import com.haoxuer.discover.data.core.Pagination;
import com.quhaodian.haodian.data.entity.UserCompliment;

public interface UserComplimentDao extends BaseDao<UserCompliment, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserCompliment findById(Long id);

	public UserCompliment save(UserCompliment bean);

	public UserCompliment updateByUpdater(Updater<UserCompliment> updater);

	public UserCompliment deleteById(Long id);
}