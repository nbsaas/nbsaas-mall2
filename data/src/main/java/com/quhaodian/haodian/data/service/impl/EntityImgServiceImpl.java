package com.quhaodian.haodian.data.service.impl;

import com.quhaodian.haodian.data.dao.EntityImgDao;
import com.quhaodian.haodian.data.entity.EntityImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.discover.data.core.Updater;
import com.quhaodian.haodian.data.service.EntityImgService;

@Service
@Transactional
public class EntityImgServiceImpl implements EntityImgService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public EntityImg findById(Integer id) {
		EntityImg entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public EntityImg save(EntityImg bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public EntityImg update(EntityImg bean) {
		Updater<EntityImg> updater = new Updater<EntityImg>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public EntityImg deleteById(Integer id) {
		EntityImg bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public EntityImg[] deleteByIds(Integer[] ids) {
		EntityImg[] beans = new EntityImg[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private EntityImgDao dao;

	@Autowired
	public void setDao(EntityImgDao dao) {
		this.dao = dao;
	}
}