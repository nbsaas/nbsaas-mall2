package com.quhaodian.data.service.impl;

import com.quhaodian.data.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.quhaodian.data.dao.NotificationDao;
import com.quhaodian.data.entity.Notification;

@Service
@Transactional
public class NotificationServiceImpl implements NotificationService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public Notification findById(Long id) {
		Notification entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public Notification save(Notification bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public Notification update(Notification bean) {
		Updater<Notification> updater = new Updater<Notification>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public Notification deleteById(Long id) {
		Notification bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public Notification[] deleteByIds(Long[] ids) {
		Notification[] beans = new Notification[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private NotificationDao dao;

	@Autowired
	public void setDao(NotificationDao dao) {
		this.dao = dao;
	}
}