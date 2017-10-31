package com.quhaodian.data.service.impl;

import com.quhaodian.data.dao.ContentCountDao;
import com.quhaodian.data.entity.ContentCount;
import com.quhaodian.data.service.ContentCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;

@Service
@Transactional
public class ContentCountServiceImpl implements ContentCountService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public ContentCount findById(Integer id) {
		ContentCount entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public ContentCount save(ContentCount bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public ContentCount update(ContentCount bean) {
		Updater<ContentCount> updater = new Updater<ContentCount>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public ContentCount deleteById(Integer id) {
		ContentCount bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public ContentCount[] deleteByIds(Integer[] ids) {
		ContentCount[] beans = new ContentCount[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private ContentCountDao dao;

	@Autowired
	public void setDao(ContentCountDao dao) {
		this.dao = dao;
	}
}