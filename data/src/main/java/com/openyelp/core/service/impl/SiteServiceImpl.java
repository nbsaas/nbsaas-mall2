package com.openyelp.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openyelp.core.dao.SiteDao;
import com.openyelp.core.entity.Site;
import com.openyelp.core.service.SiteService;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;

@Service
@Transactional
public class SiteServiceImpl implements SiteService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public Site findById(Integer id) {
		Site entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public Site save(Site bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public Site update(Site bean) {
		Updater<Site> updater = new Updater<Site>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public Site deleteById(Integer id) {
		Site bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public Site[] deleteByIds(Integer[] ids) {
		Site[] beans = new Site[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private SiteDao dao;

	@Autowired
	public void setDao(SiteDao dao) {
		this.dao = dao;
	}
}