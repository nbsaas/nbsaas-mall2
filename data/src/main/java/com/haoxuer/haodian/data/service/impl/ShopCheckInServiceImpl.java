package com.haoxuer.haodian.data.service.impl;

import com.haoxuer.haodian.data.entity.ShopCheckIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.haodian.data.dao.ShopCheckInDao;
import com.haoxuer.haodian.data.service.ShopCheckInService;

@Service
@Transactional
public class ShopCheckInServiceImpl implements ShopCheckInService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public ShopCheckIn findById(Long id) {
		ShopCheckIn entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public ShopCheckIn save(ShopCheckIn bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public ShopCheckIn update(ShopCheckIn bean) {
		Updater<ShopCheckIn> updater = new Updater<ShopCheckIn>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public ShopCheckIn deleteById(Long id) {
		ShopCheckIn bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public ShopCheckIn[] deleteByIds(Long[] ids) {
		ShopCheckIn[] beans = new ShopCheckIn[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private ShopCheckInDao dao;

	@Autowired
	public void setDao(ShopCheckInDao dao) {
		this.dao = dao;
	}
}