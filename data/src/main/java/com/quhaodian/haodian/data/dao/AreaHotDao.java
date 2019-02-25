package com.quhaodian.haodian.data.dao;


import com.quhaodian.haodian.data.entity.AreaHot;
import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import com.haoxuer.discover.data.core.Pagination;

public interface AreaHotDao extends BaseDao<AreaHot, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public AreaHot findById(Integer id);

	public AreaHot save(AreaHot bean);

	public AreaHot updateByUpdater(Updater<AreaHot> updater);

	public AreaHot deleteById(Integer id);
}