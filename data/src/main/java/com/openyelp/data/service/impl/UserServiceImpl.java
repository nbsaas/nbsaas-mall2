package com.openyelp.data.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.common.security.Digests;
import com.ada.common.security.Encodes;
import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.ada.userfriend.data.dao.UserFollowDao;
import com.ada.user.data.dao.UserInfoDao;
import com.ada.userfriend.data.entity.UserFollow;
import com.ada.user.data.entity.UserInfo;
import com.ada.user.data.entity.UserRole;
import com.openyelp.data.dao.PhotoDao;
import com.openyelp.data.dto.UserFollowState;
import com.openyelp.data.entity.Photo;
import com.openyelp.data.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Finder finder=Finder.create("from UserInfo u order by u.lastDate desc ");
		Pagination page = dao.find(finder, pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public UserInfo findById(Long id) {
		UserInfo entity =null;
		try {
			 entity = dao.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

	@Transactional
	public UserInfo save(UserInfo bean) {
		UserInfo user = new UserInfo();
		List<UserInfo> us = dao.findByProperty("username", bean.getUsername());
		if (us != null && us.size() > 0) {
			user.setId(-1l);
		} else {
			entryptPassword(bean);
			user = dao.save(bean);
		}
		return user;
	}

	@Transactional
	public UserInfo update(UserInfo bean) {
		Updater<UserInfo> updater = new Updater<UserInfo>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public UserInfo deleteById(Long id) {
		UserInfo bean = dao.deleteById(id);
		return bean;
	}

	@Transactional
	public UserInfo[] deleteByIds(Long[] ids) {
		UserInfo[] beans = new UserInfo[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserInfoDao dao;

	@Autowired
	public void setDao(UserInfoDao dao) {
		this.dao = dao;
	}

	@Transactional
	@Override
	public boolean addRole(Long id, UserRole bean) {
		boolean result = false;
		UserInfo entity = dao.findById(id);
		result = entity.getRoles().add(bean);
		return result;
	}

	@Override
	public UserInfo findByUsername(String username) {
		UserInfo result = null;
		Finder finder = Finder.create();
		finder.append("from UserInfo u where u.username ='" + username + "'");
		List<UserInfo> us = dao.find(finder);
		if (us != null && us.size() > 0) {
			result = us.get(0);
		}
		return result;
	}

	/**
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	private void entryptPassword(UserInfo user) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		user.setSalt(Encodes.encodeHex(salt));

		byte[] hashPassword = Digests.sha1(user.getPlainPassword().getBytes(),
				salt, HASH_INTERATIONS);
		user.setPassword(Encodes.encodeHex(hashPassword));
	}

	/**
	 * 验证原密码是否正确
	 * 
	 * @param user
	 * @param oldPwd
	 * @return
	 */
	public boolean checkPassword(UserInfo user, String oldPassword) {
		byte[] salt = Encodes.decodeHex(user.getSalt());
		byte[] hashPassword = Digests.sha1(oldPassword.getBytes(), salt,
				HASH_INTERATIONS);
		if (user.getPassword().equals(Encodes.encodeHex(hashPassword))) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 修改用户登录
	 * 
	 * @param user
	 */
	@Transactional
	public UserInfo updateUserLogin(UserInfo user) {
		user = dao.findById(user.getId());
		user.setLastDate(new Date());
		Integer times = user.getLoginSize();
		if (times == null) {
			times = 0;
		}
		times++;
		user.setLoginSize(times);
		return update(user);
	}

	@Transactional
	@Override
	public UserInfo login(String username, String password, String macaddress) {
		UserInfo result = null;
		Finder finder = Finder.create();
		finder.append("from UserInfo u where u.username ='" + username + "'");
		// finder.append("  and  u.password = '" + password + "'");
		List<UserInfo> us = dao.find(finder);
		if (us != null && us.size() > 0) {
			result = us.get(0);
			if (checkPassword(result, password)) {
				//result.setMacaddress(macaddress);
				result.setLastDate(new Date());
				Integer logintime = result.getLoginSize();
				if (logintime == null) {
					logintime = 0;
				}
				logintime++;
				result.setLoginSize(logintime);
			} else {
				result = null;
			}

		}
		return result;
	}

	@Transactional
	@Override
	public UserInfo updatePassword(Long userid, String oldpassword,
			String password) {
		UserInfo user = dao.findById(userid);
		if (user != null) {
			if (checkPassword(user, oldpassword)) {
				user.setPlainPassword(password);
				entryptPassword(user);
			} else {
				user = new UserInfo();
				user.setId(-1l);
			}
		} else {
			user = new UserInfo();
			user.setId(-2l);
		}
		return user;
	}

	@Transactional(readOnly = true)
	@Override
	public UserInfo findByName(String name) {
		UserInfo result = null;
		Finder finder = Finder.create();
		finder.append("from UserInfo u where u.username =:name");
		finder.setParam("name", name);
		List<UserInfo> us = dao.find(finder);
		if (us != null && us.size() > 0) {
			result = us.get(0);
		}
		if (result == null) {
			Finder finder2 = Finder.create();
			finder2.append("from UserInfo u where u.name =:name");
			finder2.setParam("name", name);
			List<UserInfo> uss = dao.find(finder2);
			if (uss != null && uss.size() > 0) {
				result = uss.get(0);
			}

		}
		return result;
	}

	@Transactional(readOnly = true)
	@Override
	public Pagination findByName(String name, int pageNo, int pageSize) {

		Finder finder = Finder.create();
		finder.append("from UserInfo u where u.name like:name");
		finder.setParam("name", "%" + name + "%");
		Pagination result = dao.find(finder, pageNo, pageSize);
		List list = result.getList();
		if (list != null && list.size() > 0) {
			return result;
		} else {
			Finder finder2 = Finder.create();
			finder2.append("from UserInfo u where u.username like  :name");
			finder2.setParam("name", name);
			return dao.find(finder2, pageNo, pageSize);

		}
	}

	@Autowired
	PhotoDao photoDao;

	@Autowired
	UserFollowDao followDao;
	
	
	@Transactional
	@Override
	public UserInfo updatePhoto(Long uid, Long id) {
		UserInfo userinfo = null;
		try {
			userinfo = dao.findById(uid);
			Photo photo = photoDao.findById(id);
			userinfo.setAvatar(photo.getUrl());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return userinfo;
	}
	@Transactional(readOnly = true)
	@Override
	public Pagination findByFollowName(String name,long userid, int pageNo, int pageSize) {
		Finder finder = Finder.create();
		finder.append("from UserInfo u where u.name like:name");
		finder.setParam("name", "%" + name + "%");
		finder.append(" order by u.name asc");
		Pagination result = dao.find(finder, pageNo, pageSize);
		List list = result.getList();
		List<UserFollowState> datas=new ArrayList<UserFollowState>();
		if (list != null && list.size() > 0) {
			
			for (Object object : list) {
				UserInfo u=(UserInfo)object;
				UserFollowState f=new UserFollowState(u);
				UserFollow follow=	followDao.findById(userid, u.getId());
				if(follow!=null){
					f.setState(1);
				}else{
					f.setState(-1);
				}
				datas.add(f);
			}
			result.setList(datas);
		} else {
			Finder finder2 = Finder.create();
			finder2.append("from UserInfo u where u.username like  :name");
			finder2.setParam("name", name);
			finder2.append(" order by u.name asc");
			result= dao.find(finder2, pageNo, pageSize);
			list = result.getList();
			if (list != null && list.size() > 0) {
				for (Object object : list) {
					UserInfo u=(UserInfo)object;
					UserFollowState f=new UserFollowState(u);
					UserFollow follow=	followDao.findById(userid, u.getId());
					if(follow!=null){
						f.setState(1);
					}else{
						f.setState(-1);
					}
					datas.add(f);
				}
				result.setList(datas);
			}
		}
		return result;

	}
	@Transactional
	@Override
	public UserInfo loginqq(String openid, String nickname, String figureurl_qq_1) {
		UserInfo result = null;
		Finder finder = Finder.create();
		finder.append("from UserInfo u where u.username ='" + openid + "'");
		// finder.append("  and  u.password = '" + password + "'");
		List<UserInfo> us = dao.find(finder);
		if (us != null && us.size() > 0) {
			result=us.get(0);
		}else{
			UserInfo user=new UserInfo();
			user.setUsername(openid);
			user.setName(nickname);
			user.setName(nickname);
			user.setAvatar(figureurl_qq_1);
			user.setPlainPassword("123456");
			entryptPassword(user);
			result=dao.save(user);
		}
		return result;
	}
}