package com.quhaodian.data.service.impl;

import com.quhaodian.data.dao.ShopAttrDao;
import com.quhaodian.data.entity.ShopAttr;
import com.quhaodian.data.service.ShopAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;

@Service
@Transactional
public class ShopAttrServiceImpl implements ShopAttrService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public ShopAttr findById(Long id) {
		ShopAttr entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public ShopAttr save(ShopAttr bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public ShopAttr update(ShopAttr bean) {
		Updater<ShopAttr> updater = new Updater<ShopAttr>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public ShopAttr deleteById(Long id) {
		ShopAttr bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public ShopAttr[] deleteByIds(Long[] ids) {
		ShopAttr[] beans = new ShopAttr[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private ShopAttrDao dao;

	@Autowired
	public void setDao(ShopAttrDao dao) {
		this.dao = dao;
	}
}