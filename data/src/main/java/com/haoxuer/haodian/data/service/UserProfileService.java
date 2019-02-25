package com.haoxuer.haodian.data.service;

import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.haodian.data.entity.UserProfile;

public interface UserProfileService {
	public Pagination getPage(int pageNo, int pageSize);

	public UserProfile findById(Long id);

	public UserProfile save(UserProfile bean);

	public UserProfile update(UserProfile bean);

	public UserProfile deleteById(Long id);
	
	public UserProfile[] deleteByIds(Long[] ids);
}