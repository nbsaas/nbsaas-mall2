package com.openyelp.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.openyelp.data.entity.UserFollow;

public interface UserFollowDao extends BaseDao<UserFollow, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserFollow findById(Long id);
	public UserFollow findById(Long id,Long friendid);

	public UserFollow save(UserFollow bean);

	public UserFollow updateByUpdater(Updater<UserFollow> updater);

	public UserFollow deleteById(Long id);
}