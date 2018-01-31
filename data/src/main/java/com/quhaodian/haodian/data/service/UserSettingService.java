package com.quhaodian.haodian.data.service;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.haodian.data.entity.UserSetting;

public interface UserSettingService {
	public Pagination getPage(int pageNo, int pageSize);

	public UserSetting findById(Long id);
	public UserSetting findByUser(Long id);

	public UserSetting save(UserSetting bean);

	public UserSetting update(UserSetting bean);

	public UserSetting deleteById(Long id);
	
	public UserSetting[] deleteByIds(Long[] ids);
}