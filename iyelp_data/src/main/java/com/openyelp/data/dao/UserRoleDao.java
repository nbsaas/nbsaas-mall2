package com.openyelp.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.openyelp.data.entity.UserRole;

public interface UserRoleDao extends BaseDao<UserRole, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserRole findById(Long id);

	public UserRole save(UserRole bean);

	public UserRole updateByUpdater(Updater<UserRole> updater);

	public UserRole deleteById(Long id);
}