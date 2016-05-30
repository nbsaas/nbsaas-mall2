package com.openyelp.data.service;

import com.openyelp.annotation.RestFul;
import com.ada.data.core.Pagination;
import com.openyelp.data.entity.UserPoints;


@RestFul(api=UserPointsService.class,value="UserPointsService")
public interface UserPointsService {
	public Pagination getPage(int pageNo, int pageSize);

	public UserPoints findById(Long id);

	public UserPoints save(UserPoints bean);

	public UserPoints update(UserPoints bean);

	public UserPoints deleteById(Long id);
	
	public UserPoints[] deleteByIds(Long[] ids);
}