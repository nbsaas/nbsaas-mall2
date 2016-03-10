package com.openyelp.data.service;

import com.openyelp.annotation.RestFul;
import com.ada.data.core.Pagination;
import com.openyelp.data.entity.UserFriend;


@RestFul(api=UserFriendService.class,value="UserFriendService")
public interface UserFriendService {
	public Pagination getPage(int pageNo, int pageSize);

	public UserFriend findById(Long id);

	public UserFriend save(UserFriend bean);

	public UserFriend update(UserFriend bean);

	public UserFriend deleteById(Long id);
	
	public UserFriend[] deleteByIds(Long[] ids);
	
	public Pagination pageByUser(Long id,int pageNo, int pageSize);
	
	public Pagination pageByUser(Long id,String key,int pageNo, int pageSize);

}