package com.quhaodian.haodian.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import com.haoxuer.discover.data.core.Pagination;
import com.quhaodian.haodian.data.entity.UserPoints;

public interface UserPointsDao extends BaseDao<UserPoints, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserPoints findById(Long id);

	public UserPoints save(UserPoints bean);

	public UserPoints updateByUpdater(Updater<UserPoints> updater);

	public UserPoints deleteById(Long id);
}