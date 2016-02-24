package com.openyelp.data.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openyelp.data.core.Finder;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;
import com.openyelp.data.dao.NotificationDao;
import com.openyelp.data.dao.UserDao;
import com.openyelp.data.dao.UserFriendRequestDao;
import com.openyelp.data.entity.Notification;
import com.openyelp.data.entity.UserFriendRequest;
import com.openyelp.data.entity.UserInfo;
import com.openyelp.data.service.UserFriendRequestService;

@Service
@Transactional
public class UserFriendRequestServiceImpl implements UserFriendRequestService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public UserFriendRequest findById(Long id) {
		UserFriendRequest entity = dao.findById(id);
		return entity;
	}

	@Autowired
	UserDao userInfoDao;

	@Autowired
	NotificationDao notificationDao;
	@Transactional
	public UserFriendRequest save(UserFriendRequest bean) {
		
		bean.setAddDate(new Date());
		bean.setLastDate(new Date());

		dao.save(bean);
		Long uid = bean.getFriend().getId();
		UserInfo u = userInfoDao.findById(uid);
		if(u!=null){
			String name="";
			if(u.getName()!=null){
				 name=u.getName();	
			}else{
				name=u.getUsername();
			}
			String msg = name+"请求添加您为好友";
			Notification notice=new Notification();
			notice.setUserInfo(bean.getUserInfo());
			notice.setCategory(1);
			notice.setFrom(bean.getFriend());
			notice.setNote(msg);
			notice.setTitle(msg);
			notice.setOid(bean.getId());
			notice.setState(0);
			notice.setName("");
			notice.setHeadimg("");
			notificationDao.save(notice);
		}
		return bean;
	}

	@Transactional
	public UserFriendRequest update(UserFriendRequest bean) {
		Updater<UserFriendRequest> updater = new Updater<UserFriendRequest>(
				bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public UserFriendRequest deleteById(Long id) {
		UserFriendRequest bean = dao.deleteById(id);
		return bean;
	}

	@Transactional
	public UserFriendRequest[] deleteByIds(Long[] ids) {
		UserFriendRequest[] beans = new UserFriendRequest[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserFriendRequestDao dao;

	@Autowired
	public void setDao(UserFriendRequestDao dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	@Override
	public Pagination pageByUser(Long userid, String key, int pageNo,
			int pageSize) {
		Finder finder=Finder.create();
		finder.append("from  UserFriendRequest u where u.userInfo.id =:userid");
		finder.setParam("userid", userid);
		finder.append(" and u.userInfo.name like :key ");
		finder.setParam("key","%"+key+"%");
		finder.append(" order by u.id desc ");
		return dao.find(finder, pageNo, pageSize);
	}
	
	@Transactional(readOnly = true)
	@Override
	public Pagination pageByUser(Long userid, int pageNo, int pageSize) {
		Finder finder=Finder.create();
		finder.append("from  UserFriendRequest u where u.userInfo.id =:userid");
		finder.setParam("userid", userid);
		finder.append(" order by u.id desc ");
		return dao.find(finder, pageNo, pageSize);
	}
}