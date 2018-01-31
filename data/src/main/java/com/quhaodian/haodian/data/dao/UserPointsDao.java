package com.quhaodian.haodian.data.dao;


import  com.quhaodian.data.core.BaseDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.haodian.data.entity.UserPoints;

public interface UserPointsDao extends BaseDao<UserPoints, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserPoints findById(Long id);

	public UserPoints save(UserPoints bean);

	public UserPoints updateByUpdater(Updater<UserPoints> updater);

	public UserPoints deleteById(Long id);
}