package com.quhaodian.haodian.data.service.impl;

import java.util.List;

import com.quhaodian.haodian.data.dao.UserProfileDao;
import com.quhaodian.haodian.data.entity.UserProfile;
import com.quhaodian.haodian.data.service.UserProfileService;
import com.quhaodian.haodian.shiro.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.quhaodian.user.data.entity.UserInfo;

@Service
@Transactional
public class UserProfileServiceImpl implements UserProfileService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public UserProfile findById(Long id) {
		UserProfile entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public UserProfile save(UserProfile bean) {
		dao.save(bean);
		return bean;
	}

    
    @Transactional
	public UserProfile update(UserProfile bean) {
    	
    	UserInfo user=	bean.getUser();
    	List<UserProfile> ps= 	dao.findByProperty("user.id", user.getId());
    	if(ps!=null&&ps.size()>0){
    		long id=ps.get(0).getId();
    		bean.setId(id);
    		bean.getUser().setName(bean.getFirst_name());
    		UserUtil.getCurrentUser().setName(bean.getFirst_name());
    		Updater<UserProfile> updater = new Updater<UserProfile>(bean);
    		bean = dao.updateByUpdater(updater);
    	}else{
    		dao.save(bean);
    	}
		return bean;
	}

    @Transactional
	public UserProfile deleteById(Long id) {
		UserProfile bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public UserProfile[] deleteByIds(Long[] ids) {
		UserProfile[] beans = new UserProfile[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserProfileDao dao;

	@Autowired
	public void setDao(UserProfileDao dao) {
		this.dao = dao;
	}
}