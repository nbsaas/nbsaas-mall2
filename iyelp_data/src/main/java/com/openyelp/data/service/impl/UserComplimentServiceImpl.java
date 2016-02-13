package com.openyelp.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openyelp.data.core.Finder;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;
import com.openyelp.data.dao.UserComplimentDao;
import com.openyelp.data.entity.UserCompliment;
import com.openyelp.data.service.UserComplimentService;

@Service
@Transactional
public class UserComplimentServiceImpl implements UserComplimentService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public UserCompliment findById(Long id) {
		UserCompliment entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public UserCompliment save(UserCompliment bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public UserCompliment update(UserCompliment bean) {
		Updater<UserCompliment> updater = new Updater<UserCompliment>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public UserCompliment deleteById(Long id) {
		UserCompliment bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public UserCompliment[] deleteByIds(Long[] ids) {
		UserCompliment[] beans = new UserCompliment[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserComplimentDao dao;

	@Autowired
	public void setDao(UserComplimentDao dao) {
		this.dao = dao;
	}

	
	@Transactional(readOnly = true)
	@Override
	public Pagination pageByUser(long id, int pageNo, int pageSize) {
		Finder finder=Finder.create();
		finder.append("from UserCompliment u where u.userInfo.id =:userid");
		finder.setParam("userid", id);
		finder.append("   order by u.id desc");
		return dao.find(finder, pageNo, pageSize);
	}
	@Transactional(readOnly = true)
	@Override
	public Pagination pageByUser(long id, int state, int pageNo, int pageSize) {
		Finder finder=Finder.create();
		finder.append("from UserCompliment u where u.userInfo.id =:userid");
		finder.setParam("userid", id);
		finder.append("  and  u.state=:state");
		finder.setParam("state", state);
		finder.append("   order by u.id desc");
		return dao.find(finder, pageNo, pageSize);
	}
}