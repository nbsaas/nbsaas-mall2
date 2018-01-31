package com.quhaodian.data.service.impl;

import java.util.List;

import com.quhaodian.data.entity.UserSetting;
import com.quhaodian.data.service.UserSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.quhaodian.user.data.dao.UserInfoDao;
import com.quhaodian.user.data.entity.UserInfo;
import com.quhaodian.data.dao.UserSettingDao;

@Service
@Transactional
public class UserSettingServiceImpl implements UserSettingService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public UserSetting findById(Long id) {
		UserSetting entity = dao.findById(id);
		return entity;
	}

	@Transactional
	public UserSetting save(UserSetting bean) {
		dao.save(bean);
		return bean;
	}

	@Transactional
	public UserSetting update(UserSetting bean) {
		Updater<UserSetting> updater = new Updater<UserSetting>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public UserSetting deleteById(Long id) {
		UserSetting bean = dao.deleteById(id);
		return bean;
	}

	@Transactional
	public UserSetting[] deleteByIds(Long[] ids) {
		UserSetting[] beans = new UserSetting[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserSettingDao dao;

	@Autowired
	public void setDao(UserSettingDao dao) {
		this.dao = dao;
	}

	@Autowired
	UserInfoDao userDao;

	@Transactional
	@Override
	public UserSetting findByUser(Long id) {
		List<UserSetting> settings = dao.findByProperty("user.id", id);
		if (settings != null && settings.size() > 0) {
			return settings.get(0);
		} else {
			UserInfo user = userDao.findById(id);
			if (user != null) {
				UserSetting set = new UserSetting();
				set.setUser(user);
				dao.save(set);
				return set;
			} else {
				return null;
			}
		}
	}
}