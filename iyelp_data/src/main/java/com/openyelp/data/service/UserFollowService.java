package com.openyelp.data.service;

import com.openyelp.annotation.RestFul;
import com.ada.data.core.Pagination;
import com.openyelp.data.entity.UserFollow;


@RestFul(api=UserFollowService.class,value="UserFollowService")
public interface UserFollowService {
	public Pagination getPage(int pageNo, int pageSize);
	public Pagination pageByUser(long userid,int pageNo, int pageSize);

	public UserFollow findById(Long id);

	public UserFollow save(UserFollow bean);
	public UserFollow remove(UserFollow bean);

	public UserFollow update(UserFollow bean);

	public UserFollow deleteById(Long id);
	
	public UserFollow[] deleteByIds(Long[] ids);
}