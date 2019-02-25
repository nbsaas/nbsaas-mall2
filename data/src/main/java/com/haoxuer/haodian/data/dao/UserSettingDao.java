package com.haoxuer.haodian.data.dao;


import  com.haoxuer.discover.data.core.BaseDao;
import  com.haoxuer.discover.data.core.Updater;
import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.haodian.data.entity.UserSetting;

public interface UserSettingDao extends BaseDao<UserSetting, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public UserSetting findById(Long id);

	public UserSetting save(UserSetting bean);

	public UserSetting updateByUpdater(Updater<UserSetting> updater);

	public UserSetting deleteById(Long id);
}