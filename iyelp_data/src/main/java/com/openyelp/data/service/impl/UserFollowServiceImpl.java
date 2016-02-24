package com.openyelp.data.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openyelp.data.core.Finder;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;
import com.openyelp.data.dao.UserFollowDao;
import com.openyelp.data.entity.UserFollow;
import com.openyelp.data.service.UserFollowService;

@Service
@Transactional
public class UserFollowServiceImpl implements UserFollowService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public UserFollow findById(Long id) {
		UserFollow entity = dao.findById(id);
		return entity;
	}

	@Transactional
	public UserFollow save(UserFollow bean) {
		if (bean == null) {
			return null;
		}
		if (bean.getUser() == null) {
			return null;
		}
		if (bean.getFriend() == null) {
			return null;
		}
		bean.setAddDate(new Date());
		Finder finder = Finder.create();
		finder.append("from UserFollow f where f.user.id=:userid");
		finder.setParam("userid", bean.getUser().getId());
		finder.append(" and  f.friend.id=:friendid");
		finder.setParam("friendid", bean.getFriend().getId());
		List<UserFollow> follows = dao.find(finder);
		if (follows != null && follows.size() > 0) {
			return null;
		} else {
			dao.save(bean);
		}
		return bean;
	}

	@Transactional
	public UserFollow update(UserFollow bean) {
		Updater<UserFollow> updater = new Updater<UserFollow>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public UserFollow deleteById(Long id) {
		UserFollow bean = dao.deleteById(id);
		return bean;
	}

	@Transactional
	public UserFollow[] deleteByIds(Long[] ids) {
		UserFollow[] beans = new UserFollow[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserFollowDao dao;

	@Autowired
	public void setDao(UserFollowDao dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	@Override
	public Pagination pageByUser(long userid, int pageNo, int pageSize) {
		Finder finder = Finder.create();
		finder.append("from UserFollow f where f.user.id=:userid");
		finder.setParam("userid", userid);
		finder.append("  order by f.id desc");
		return dao.find(finder, pageNo, pageSize);
	}

	@Transactional
	@Override
	public UserFollow remove(UserFollow bean) {
		UserFollow result = new UserFollow();
		Finder finder = Finder.create();
		finder.append("from UserFollow f where f.user.id=:userid");
		finder.setParam("userid", bean.getUser().getId());
		finder.append(" and  f.friend.id=:friendid ");
		finder.setParam("friendid", bean.getFriend().getId());
		List<UserFollow> follows = dao.find(finder);
		if (follows != null && follows.size() > 0) {
			dao.delete(follows.get(0));
			result.setId(1l);
			return null;
		} else {
			result.setId(-1l);
		}
		return result;
	}
}