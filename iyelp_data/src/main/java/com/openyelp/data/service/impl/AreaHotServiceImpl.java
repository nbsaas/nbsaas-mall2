package com.openyelp.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openyelp.data.core.Finder;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;
import com.openyelp.data.dao.AreaHotDao;
import com.openyelp.data.entity.AreaHot;
import com.openyelp.data.service.AreaHotService;

@Service
@Transactional
public class AreaHotServiceImpl implements AreaHotService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public AreaHot findById(Integer id) {
		AreaHot entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public AreaHot save(AreaHot bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public AreaHot update(AreaHot bean) {
		Updater<AreaHot> updater = new Updater<AreaHot>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public AreaHot deleteById(Integer id) {
		AreaHot bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public AreaHot[] deleteByIds(Integer[] ids) {
		AreaHot[] beans = new AreaHot[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private AreaHotDao dao;

	@Autowired
	public void setDao(AreaHotDao dao) {
		this.dao = dao;
	}

	@Override
	public Pagination page(int curpage, int pagesize) {
		Finder finder=Finder.create();
		finder.append("from AreaHot h order by h.id  desc ");
		// TODO Auto-generated method stub
		return dao.find(finder, curpage, pagesize);
	}
}