package com.openyelp.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openyelp.data.core.Finder;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;
import com.openyelp.data.dao.EventInfoCommentDao;
import com.openyelp.data.entity.EventInfoComment;
import com.openyelp.data.service.EventInfoCommentService;

@Service
@Transactional
public class EventInfoCommentServiceImpl implements EventInfoCommentService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public EventInfoComment findById(Long id) {
		EventInfoComment entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public EventInfoComment save(EventInfoComment bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public EventInfoComment update(EventInfoComment bean) {
		Updater<EventInfoComment> updater = new Updater<EventInfoComment>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public EventInfoComment deleteById(Long id) {
		EventInfoComment bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public EventInfoComment[] deleteByIds(Long[] ids) {
		EventInfoComment[] beans = new EventInfoComment[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private EventInfoCommentDao dao;

	@Autowired
	public void setDao(EventInfoCommentDao dao) {
		this.dao = dao;
	}
	@Transactional(readOnly = true)
	@Override
	public Pagination pageByEventId(long id, int pageNo, int pageSize) {
		Finder finder=Finder.create();
		finder.append("from EventInfoComment e where e.eventInfo.id=:eventid");
		finder.setParam("eventid", id);
		finder.append(" order by e.id desc");
		return dao.find(finder, pageNo, pageSize);
	}
}