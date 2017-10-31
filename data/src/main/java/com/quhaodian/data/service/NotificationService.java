package com.quhaodian.data.service;

import com.ada.data.core.Pagination;
import com.quhaodian.data.entity.Notification;

public interface NotificationService {
	public Pagination getPage(int pageNo, int pageSize);

	public Notification findById(Long id);

	public Notification save(Notification bean);

	public Notification update(Notification bean);

	public Notification deleteById(Long id);
	
	public Notification[] deleteByIds(Long[] ids);
}