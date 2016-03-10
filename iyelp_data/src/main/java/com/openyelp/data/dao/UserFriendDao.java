package com.openyelp.data.dao;


import com.ada.data.core.BaseDao;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.openyelp.data.entity.UserFriend;

public interface UserFriendDao extends BaseDao<UserFriend, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserFriend findById(Long id);

	public UserFriend save(UserFriend bean);

	public UserFriend updateByUpdater(Updater<UserFriend> updater);

	public UserFriend deleteById(Long id);
}