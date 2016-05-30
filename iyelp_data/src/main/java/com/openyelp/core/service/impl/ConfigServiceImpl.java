package com.openyelp.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openyelp.core.dao.ConfigDao;
import com.openyelp.core.entity.Config;
import com.openyelp.core.service.ConfigService;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;

@Service
@Transactional
public class ConfigServiceImpl implements ConfigService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public Config findById(Integer id) {
		Config entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public Config save(Config bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public Config update(Config bean) {
		Updater<Config> updater = new Updater<Config>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public Config deleteById(Integer id) {
		Config bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public Config[] deleteByIds(Integer[] ids) {
		Config[] beans = new Config[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private ConfigDao dao;

	@Autowired
	public void setDao(ConfigDao dao) {
		this.dao = dao;
	}
}