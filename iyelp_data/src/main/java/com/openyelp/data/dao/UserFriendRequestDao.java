package com.openyelp.data.dao;


import com.openyelp.data.core.BaseDao;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;
import com.openyelp.data.entity.UserFriendRequest;

public interface UserFriendRequestDao extends BaseDao<UserFriendRequest, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserFriendRequest findById(Long id);

	public UserFriendRequest save(UserFriendRequest bean);

	public UserFriendRequest updateByUpdater(Updater<UserFriendRequest> updater);

	public UserFriendRequest deleteById(Long id);
}