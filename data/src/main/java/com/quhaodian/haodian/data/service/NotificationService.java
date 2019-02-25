package com.quhaodian.haodian.data.service;

import com.quhaodian.haodian.data.entity.Notification;
import com.haoxuer.discover.data.core.Pagination;

public interface NotificationService {
	public Pagination getPage(int pageNo, int pageSize);

	public Notification findById(Long id);

	public Notification save(Notification bean);

	public Notification update(Notification bean);

	public Notification deleteById(Long id);
	
	public Notification[] deleteByIds(Long[] ids);
}