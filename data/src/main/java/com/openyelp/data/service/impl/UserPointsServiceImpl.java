package com.openyelp.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.openyelp.data.dao.UserPointsDao;
import com.openyelp.data.entity.UserPoints;
import com.openyelp.data.service.UserPointsService;

@Service
@Transactional
public class UserPointsServiceImpl implements UserPointsService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public UserPoints findById(Long id) {
		UserPoints entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public UserPoints save(UserPoints bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public UserPoints update(UserPoints bean) {
		Updater<UserPoints> updater = new Updater<UserPoints>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public UserPoints deleteById(Long id) {
		UserPoints bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public UserPoints[] deleteByIds(Long[] ids) {
		UserPoints[] beans = new UserPoints[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserPointsDao dao;

	@Autowired
	public void setDao(UserPointsDao dao) {
		this.dao = dao;
	}
}