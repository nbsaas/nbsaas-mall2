package com.quhaodian.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.quhaodian.data.dao.ShopBackDao;
import com.quhaodian.data.entity.ShopBack;
import com.quhaodian.data.service.ShopBackService;

@Service
@Transactional
public class ShopBackServiceImpl implements ShopBackService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public ShopBack findById(Long id) {
		ShopBack entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public ShopBack save(ShopBack bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public ShopBack update(ShopBack bean) {
		Updater<ShopBack> updater = new Updater<ShopBack>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public ShopBack deleteById(Long id) {
		ShopBack bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public ShopBack[] deleteByIds(Long[] ids) {
		ShopBack[] beans = new ShopBack[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private ShopBackDao dao;

	@Autowired
	public void setDao(ShopBackDao dao) {
		this.dao = dao;
	}
}