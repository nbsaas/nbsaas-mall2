package com.openyelp.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.openyelp.data.entity.Photo;

public interface PhotoDao extends BaseDao<Photo, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public Photo findById(Long id);

	public Photo save(Photo bean);

	public Photo updateByUpdater(Updater<Photo> updater);

	public Photo deleteById(Long id);
}