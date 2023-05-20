package com.haoxuer.haodian.data.service.impl;

import com.haoxuer.haodian.data.dao.ContentTagDao;
import com.haoxuer.haodian.data.entity.ContentTag;
import com.haoxuer.haodian.data.service.ContentTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.discover.data.core.Updater;

@Service
@Transactional
public class ContentTagServiceImpl implements ContentTagService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public ContentTag findById(Integer id) {
		ContentTag entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public ContentTag save(ContentTag bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public ContentTag update(ContentTag bean) {
		Updater<ContentTag> updater = new Updater<ContentTag>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public ContentTag deleteById(Integer id) {
		ContentTag bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public ContentTag[] deleteByIds(Integer[] ids) {
		ContentTag[] beans = new ContentTag[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private ContentTagDao dao;

	@Autowired
	public void setDao(ContentTagDao dao) {
		this.dao = dao;
	}
}