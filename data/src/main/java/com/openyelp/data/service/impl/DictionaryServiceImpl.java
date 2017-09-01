package com.openyelp.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.openyelp.data.dao.DictionaryDao;
import com.openyelp.data.entity.Dictionary;
import com.openyelp.data.service.DictionaryService;

@Service
@Transactional
public class DictionaryServiceImpl implements DictionaryService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public Dictionary findById(Integer id) {
		Dictionary entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public Dictionary save(Dictionary bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public Dictionary update(Dictionary bean) {
		Updater<Dictionary> updater = new Updater<Dictionary>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public Dictionary deleteById(Integer id) {
		Dictionary bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public Dictionary[] deleteByIds(Integer[] ids) {
		Dictionary[] beans = new Dictionary[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private DictionaryDao dao;

	@Autowired
	public void setDao(DictionaryDao dao) {
		this.dao = dao;
	}
	@Transactional(readOnly = true)
	@Override
	public Pagination page(int pageNo, int pageSize) {
		Finder finder=Finder.create();
		finder.append("from Dictionary d");
		finder.append(" order by d.type desc");
		Pagination page = dao.find(finder, pageNo, pageSize);
		return page;
	}
}