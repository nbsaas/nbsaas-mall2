package com.haoxuer.haodian.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.haodian.data.entity.UserCity;

public interface UserCityDao extends BaseDao<UserCity, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserCity findById(Long id);

	public UserCity save(UserCity bean);

	public UserCity updateByUpdater(Updater<UserCity> updater);

	public UserCity deleteById(Long id);
}