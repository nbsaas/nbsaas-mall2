package com.openyelp.data.dao;


import com.openyelp.data.core.BaseDao;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;
import com.openyelp.data.entity.UserFriend;

public interface UserFriendDao extends BaseDao<UserFriend, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserFriend findById(Long id);

	public UserFriend save(UserFriend bean);

	public UserFriend updateByUpdater(Updater<UserFriend> updater);

	public UserFriend deleteById(Long id);
}