package com.openyelp.data.service;

import com.openyelp.annotation.RestFul;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.entity.UserFriendRequest;


@RestFul(api=UserFriendRequestService.class,value="UserFriendRequestService")
public interface UserFriendRequestService {
	public Pagination getPage(int pageNo, int pageSize);

	public UserFriendRequest findById(Long id);

	public UserFriendRequest save(UserFriendRequest bean);

	public UserFriendRequest update(UserFriendRequest bean);

	public UserFriendRequest deleteById(Long id);
	
	public UserFriendRequest[] deleteByIds(Long[] ids);
	
	public Pagination pageByUser(Long userid,String key,int pageNo, int pageSize);
	public Pagination pageByUser(Long userid,int pageNo, int pageSize);


}