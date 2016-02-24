package com.openyelp.data.dao;


import com.openyelp.data.core.BaseDao;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;
import com.openyelp.data.entity.Menu;

public interface MenuDao extends BaseDao<Menu, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public Menu findById(Integer id);

	public Menu save(Menu bean);

	public Menu updateByUpdater(Updater<Menu> updater);

	public Menu deleteById(Integer id);
}