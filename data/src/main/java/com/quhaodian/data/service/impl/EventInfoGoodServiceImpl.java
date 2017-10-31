package com.quhaodian.data.service.impl;

import com.quhaodian.data.dao.EventInfoGoodDao;
import com.quhaodian.data.entity.EventInfoGood;
import com.quhaodian.data.service.EventInfoGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;

@Service
@Transactional
public class EventInfoGoodServiceImpl implements EventInfoGoodService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public EventInfoGood findById(Long id) {
		EventInfoGood entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public EventInfoGood save(EventInfoGood bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public EventInfoGood update(EventInfoGood bean) {
		Updater<EventInfoGood> updater = new Updater<EventInfoGood>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public EventInfoGood deleteById(Long id) {
		EventInfoGood bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public EventInfoGood[] deleteByIds(Long[] ids) {
		EventInfoGood[] beans = new EventInfoGood[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private EventInfoGoodDao dao;

	@Autowired
	public void setDao(EventInfoGoodDao dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	@Override
	public Pagination pageByArea(int areadid,int pageNo, int pageSize) {
		Finder finder=Finder.create();
		finder.append("select e.eventinfo from  EventInfoGood e where e.eventinfo.area.id=:areaid ");
		finder.setParam("areaid", areadid);
		finder.append("  order by e.id desc");
		return dao.find(finder, pageNo, pageSize);
	}
}