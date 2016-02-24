package com.openyelp.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;
import com.openyelp.data.dao.UserRoleDao;
import com.openyelp.data.entity.UserRole;
import com.openyelp.data.service.UserRoleService;

@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public UserRole findById(Long id) {
		UserRole entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public UserRole save(UserRole bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public UserRole update(UserRole bean) {
		Updater<UserRole> updater = new Updater<UserRole>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public UserRole deleteById(Long id) {
		UserRole bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public UserRole[] deleteByIds(Long[] ids) {
		UserRole[] beans = new UserRole[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserRoleDao dao;

	@Autowired
	public void setDao(UserRoleDao dao) {
		this.dao = dao;
	}
}