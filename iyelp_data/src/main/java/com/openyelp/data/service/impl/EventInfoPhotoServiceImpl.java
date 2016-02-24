package com.openyelp.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openyelp.data.core.Finder;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;
import com.openyelp.data.dao.EventInfoDao;
import com.openyelp.data.dao.EventInfoPhotoDao;
import com.openyelp.data.dao.FeedDao;
import com.openyelp.data.entity.EventInfo;
import com.openyelp.data.entity.EventInfoPhoto;
import com.openyelp.data.service.EventInfoPhotoService;

@Service
@Transactional
public class EventInfoPhotoServiceImpl implements EventInfoPhotoService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public EventInfoPhoto findById(Long id) {
		EventInfoPhoto entity = dao.findById(id);
		return entity;
	}
	@Autowired
	EventInfoDao eventInfoDao;
	
	@Autowired
	FeedDao feedDao;

    @Transactional
	public EventInfoPhoto save(EventInfoPhoto bean) {
    	EventInfo info= eventInfoDao.findById(bean.getEventinfo().getId());
    	if(info!=null){
    		if(info.getImg()==null||info.getImg().length()<10){
        		info.setImg(bean.getUrl());
    		}
    		Finder finder = Finder.create();
    		finder.append("from EventInfoPhoto s where s.eventinfo.id =:eventinfoid");
    		finder.setParam("eventinfoid", bean.getEventinfo().getId());
    		int ps = dao.countQueryResult(finder);
    		info.setPhotos(ps);
    	}
		dao.save(bean);
		feedDao.addFeed(bean);
		return bean;
	}

    @Transactional
	public EventInfoPhoto update(EventInfoPhoto bean) {
		Updater<EventInfoPhoto> updater = new Updater<EventInfoPhoto>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public EventInfoPhoto deleteById(Long id) {
		EventInfoPhoto bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public EventInfoPhoto[] deleteByIds(Long[] ids) {
		EventInfoPhoto[] beans = new EventInfoPhoto[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private EventInfoPhotoDao dao;

	@Autowired
	public void setDao(EventInfoPhotoDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	@Override
	public Pagination pageByEvent(Long id, int pageNo, int pageSize) {
		Finder finder=Finder.create();
		finder.append("from EventInfoPhoto p where p.eventinfo.id =:eventid ");
		finder.setParam("eventid", id);
		finder.append(" order by p.id desc ");
		return dao.find(finder, pageNo, pageSize);
	}
}