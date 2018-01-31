package com.quhaodian.haodian.data.dao;


import  com.quhaodian.data.core.BaseDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.haodian.data.entity.Photo;

public interface PhotoDao extends BaseDao<Photo, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public Photo findById(Long id);

	public Photo save(Photo bean);

	public Photo updateByUpdater(Updater<Photo> updater);

	public Photo deleteById(Long id);
}