package com.openyelp.data.service;

import com.openyelp.annotation.RestFul;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.entity.UserProfile;
@RestFul(api=UserProfileService.class,value="UserProfileService")
public interface UserProfileService {
	public Pagination getPage(int pageNo, int pageSize);

	public UserProfile findById(Long id);

	public UserProfile save(UserProfile bean);

	public UserProfile update(UserProfile bean);

	public UserProfile deleteById(Long id);
	
	public UserProfile[] deleteByIds(Long[] ids);
}