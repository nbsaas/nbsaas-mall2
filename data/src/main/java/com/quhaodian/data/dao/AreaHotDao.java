package com.quhaodian.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import com.quhaodian.data.entity.AreaHot;

public interface AreaHotDao extends BaseDao<AreaHot, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public AreaHot findById(Integer id);

	public AreaHot save(AreaHot bean);

	public AreaHot updateByUpdater(Updater<AreaHot> updater);

	public AreaHot deleteById(Integer id);
}