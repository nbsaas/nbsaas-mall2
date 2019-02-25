package com.haoxuer.haodian.data.dao;


import com.haoxuer.haodian.data.entity.Notification;
import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import com.haoxuer.discover.data.core.Pagination;

public interface NotificationDao extends BaseDao<Notification, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public Notification findById(Long id);

	public Notification save(Notification bean);

	public Notification updateByUpdater(Updater<Notification> updater);

	public Notification deleteById(Long id);
}