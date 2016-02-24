package com.openyelp.data.service;

import java.util.List;

import com.openyelp.annotation.RestFul;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.entity.Menu;



@RestFul(api=MenuService.class,value="MenuService")
public interface MenuService {
	public Pagination getPage(int pageNo, int pageSize);

	public Menu findById(Integer id);

	public Menu save(Menu bean);

	public Menu update(Menu bean);

	public Menu deleteById(Integer id);
	
	public Menu[] deleteByIds(Integer[] ids);
	
	public List<Menu> findChild(int id);
}