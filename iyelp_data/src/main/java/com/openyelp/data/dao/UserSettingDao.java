package com.openyelp.data.dao;


import  com.openyelp.data.core.BaseDao;
import  com.openyelp.data.core.Updater;
import com.openyelp.data.core.Pagination;
import  com.openyelp.data.entity.UserSetting;

public interface UserSettingDao extends BaseDao<UserSetting, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserSetting findById(Long id);

	public UserSetting save(UserSetting bean);

	public UserSetting updateByUpdater(Updater<UserSetting> updater);

	public UserSetting deleteById(Long id);
}