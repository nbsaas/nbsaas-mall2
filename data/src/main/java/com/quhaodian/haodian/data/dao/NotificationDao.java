package com.quhaodian.haodian.data.dao;


import com.quhaodian.haodian.data.entity.Notification;
import  com.quhaodian.data.core.BaseDao;
import  com.quhaodian.data.core.Updater;
import com.quhaodian.data.core.Pagination;

public interface NotificationDao extends BaseDao<Notification, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public Notification findById(Long id);

	public Notification save(Notification bean);

	public Notification updateByUpdater(Updater<Notification> updater);

	public Notification deleteById(Long id);
}