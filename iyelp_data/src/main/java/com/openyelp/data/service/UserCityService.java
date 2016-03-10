package com.openyelp.data.service;

import com.openyelp.annotation.RestFul;
import com.ada.data.core.Pagination;
import com.openyelp.data.entity.UserCity;



@RestFul(api=UserCityService.class,value="UserCityService")
public interface UserCityService {
	public Pagination getPage(int pageNo, int pageSize);

	public UserCity findById(Long id);
	public Pagination findByUser(long userid,int pageNo, int pageSize);

	public UserCity save(UserCity bean);

	public UserCity update(UserCity bean);

	public UserCity deleteById(Long id);
	
	public UserCity[] deleteByIds(Long[] ids);
}