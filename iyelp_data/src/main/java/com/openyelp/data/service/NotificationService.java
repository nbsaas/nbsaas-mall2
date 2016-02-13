package com.openyelp.data.service;

import com.openyelp.data.core.Pagination;
import com.openyelp.data.entity.Notification;

public interface NotificationService {
	public Pagination getPage(int pageNo, int pageSize);

	public Notification findById(Long id);

	public Notification save(Notification bean);

	public Notification update(Notification bean);

	public Notification deleteById(Long id);
	
	public Notification[] deleteByIds(Long[] ids);
}