package com.openyelp.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;
import com.openyelp.data.dao.ShopTagDao;
import com.openyelp.data.entity.ShopTag;
import com.openyelp.data.service.ShopTagService;

@Service
@Transactional
public class ShopTagServiceImpl implements ShopTagService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public ShopTag findById(Long id) {
		ShopTag entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public ShopTag save(ShopTag bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public ShopTag update(ShopTag bean) {
		Updater<ShopTag> updater = new Updater<ShopTag>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public ShopTag deleteById(Long id) {
		ShopTag bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public ShopTag[] deleteByIds(Long[] ids) {
		ShopTag[] beans = new ShopTag[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private ShopTagDao dao;

	@Autowired
	public void setDao(ShopTagDao dao) {
		this.dao = dao;
	}
}