package com.openyelp.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openyelp.data.core.Finder;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;
import com.openyelp.data.dao.EventInfoCategoryDao;
import com.openyelp.data.entity.EventInfoCategory;
import com.openyelp.data.entity.Menu;
import com.openyelp.data.service.EventInfoCategoryService;

@Service
@Transactional
public class EventInfoCategoryServiceImpl implements EventInfoCategoryService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public EventInfoCategory findById(Integer id) {
		EventInfoCategory entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public EventInfoCategory save(EventInfoCategory bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public EventInfoCategory update(EventInfoCategory bean) {
		Updater<EventInfoCategory> updater = new Updater<EventInfoCategory>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public EventInfoCategory deleteById(Integer id) {
		EventInfoCategory bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public EventInfoCategory[] deleteByIds(Integer[] ids) {
		EventInfoCategory[] beans = new EventInfoCategory[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private EventInfoCategoryDao dao;

	@Autowired
	public void setDao(EventInfoCategoryDao dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	@Override
	public List<EventInfoCategory> findByPid(Integer id) {
		Finder finder=Finder.create();
		finder.append("from EventInfoCategory c where c.parent.id =:pid");
		finder.setParam("pid", id);
		return dao.find(finder);
	}

	
}