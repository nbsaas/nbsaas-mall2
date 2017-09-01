package com.quhaodian.data.dao;


import  com.ada.data.core.BaseDao;
import  com.ada.data.core.Updater;
import com.ada.data.core.Pagination;
import com.quhaodian.data.entity.UserSetting;

public interface UserSettingDao extends BaseDao<UserSetting, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserSetting findById(Long id);

	public UserSetting save(UserSetting bean);

	public UserSetting updateByUpdater(Updater<UserSetting> updater);

	public UserSetting deleteById(Long id);
}