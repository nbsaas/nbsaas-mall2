package com.quhaodian.data.dao.impl;

import com.quhaodian.data.entity.UserSetting;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.BaseDaoImpl;
import com.ada.data.core.Pagination;
import com.quhaodian.data.dao.UserSettingDao;

@Repository
public class UserSettingDaoImpl extends BaseDaoImpl<UserSetting, Long> implements UserSettingDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public UserSetting findById(Long id) {
		UserSetting entity = get(id);
		return entity;
	}

	public UserSetting save(UserSetting bean) {
		getSession().save(bean);
		return bean;
	}

	public UserSetting deleteById(Long id) {
		UserSetting entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<UserSetting> getEntityClass() {
		return UserSetting.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}