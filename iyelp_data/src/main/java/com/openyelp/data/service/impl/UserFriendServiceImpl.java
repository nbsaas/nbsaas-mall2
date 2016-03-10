package com.openyelp.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.openyelp.data.dao.UserFriendDao;
import com.openyelp.data.entity.UserFriend;
import com.openyelp.data.service.UserFriendService;

@Service
@Transactional
public class UserFriendServiceImpl implements UserFriendService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public UserFriend findById(Long id) {
		UserFriend entity = dao.findById(id);
		return entity;
	}

	@Transactional
	public UserFriend save(UserFriend bean) {
		Finder finder = Finder.create();
		finder.append("from UserFriend u where u.userInfo.id=:uid");
		finder.setParam("uid", bean.getUser().getId());
		finder.append(" and  u.friend.id =:fid");
		finder.setParam("fid", bean.getFriend().getId());
		List list = dao.find(finder);
		if(list!=null&&list.size()>0){
			bean.setId(-1l);
		}else{
			dao.save(bean);
		}
		return bean;
	}

	@Transactional
	public UserFriend update(UserFriend bean) {
		Updater<UserFriend> updater = new Updater<UserFriend>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public UserFriend deleteById(Long id) {
		UserFriend bean = dao.deleteById(id);
		return bean;
	}

	@Transactional
	public UserFriend[] deleteByIds(Long[] ids) {
		UserFriend[] beans = new UserFriend[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserFriendDao dao;

	@Autowired
	public void setDao(UserFriendDao dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	@Override
	public Pagination pageByUser(Long id, int pageNo, int pageSize) {
		Finder finder = Finder.create();
		finder.append("from UserFriend u where u.user.id=:uid");
		finder.setParam("uid", id);
		finder.append("  order by u.id desc");
		Pagination page = dao.find(finder, pageNo, pageSize);
		return page;
	}
	
	@Transactional(readOnly = true)
	@Override
	public Pagination pageByUser(Long id, String key, int pageNo, int pageSize) {
		Finder finder = Finder.create();
		finder.append("from UserFriend u where u.user.id=:uid");
		finder.setParam("uid", id);
		finder.append(" and u.user.name like :key ");
		finder.setParam("key","%"+ key+"%");
		finder.append("  order by u.id desc");
		Pagination page = dao.find(finder, pageNo, pageSize);
		return page;
	}
}