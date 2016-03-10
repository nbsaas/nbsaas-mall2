package com.openyelp.data.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.area.dao.AreaDao;
import com.ada.area.entity.Area;
import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.openyelp.data.dao.UserCityDao;
import com.openyelp.data.entity.UserCity;
import com.openyelp.data.service.UserCityService;

@Service
@Transactional
public class UserCityServiceImpl implements UserCityService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public UserCity findById(Long id) {
		UserCity entity = dao.findById(id);
		return entity;
	}

	@Autowired
	AreaDao areaDao;

	@Transactional
	public UserCity save(UserCity bean) {

		String name = "";

		String x = bean.getAddress();
		if(x!=null&&x.length()>3&&x.indexOf("市")>0){
			name=x.substring(0, x.indexOf("市"));
			Finder finder = Finder.create();
			finder.append("from Area a where a.name=:name");
			finder.setParam("name",name);
			finder.append(" and  a.levelinfo=3");
			List<Area> as = areaDao.find(finder);
			if (as != null && as.size() > 0) {
				Area area = as.get(0);
				bean.setArea(area);
				bean.setAddDate(new Date());
				bean.setLastDate(new Date());
				dao.save(bean);

			} else {
				bean.setId(-1l);
			}
		} else {
			bean.setId(-1l);
		}
	
		return bean;
	}

	@Transactional
	public UserCity update(UserCity bean) {
		Updater<UserCity> updater = new Updater<UserCity>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public UserCity deleteById(Long id) {
		UserCity bean = dao.deleteById(id);
		return bean;
	}

	@Transactional
	public UserCity[] deleteByIds(Long[] ids) {
		UserCity[] beans = new UserCity[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private UserCityDao dao;

	@Autowired
	public void setDao(UserCityDao dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	@Override
	public Pagination findByUser(long userid, int pageNo, int pageSize) {
		Finder finder=Finder.create();
		finder.append("from UserCity u where u.user.id =:userid");
		finder.setParam("userid", userid);
		finder.append(" order by u.id desc");
		
		return dao.find(finder, pageNo, pageSize);
	}
}