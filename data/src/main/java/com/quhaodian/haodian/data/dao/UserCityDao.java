package com.quhaodian.haodian.data.dao;


import  com.quhaodian.data.core.BaseDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.haodian.data.entity.UserCity;

public interface UserCityDao extends BaseDao<UserCity, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserCity findById(Long id);

	public UserCity save(UserCity bean);

	public UserCity updateByUpdater(Updater<UserCity> updater);

	public UserCity deleteById(Long id);
}