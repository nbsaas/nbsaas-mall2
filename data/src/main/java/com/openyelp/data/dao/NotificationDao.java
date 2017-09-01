package com.openyelp.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import  com.openyelp.data.entity.Notification;

public interface NotificationDao extends BaseDao<Notification, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public Notification findById(Long id);

	public Notification save(Notification bean);

	public Notification updateByUpdater(Updater<Notification> updater);

	public Notification deleteById(Long id);
}