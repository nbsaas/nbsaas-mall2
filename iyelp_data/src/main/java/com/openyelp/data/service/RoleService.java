package com.openyelp.data.service;

import com.openyelp.annotation.RestFul;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.entity.UserRole;



@RestFul(api=RoleService.class,value="RoleService")
public interface RoleService {
	public Pagination getPage(int pageNo, int pageSize);

	public UserRole findById(Long id);

	public UserRole save(UserRole bean);

	public UserRole update(UserRole bean);

	public UserRole deleteById(Long id);
	
	public UserRole[] deleteByIds(Long[] ids);
}