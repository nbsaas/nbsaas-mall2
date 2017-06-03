package com.quhaodian.data.service.impl;

import java.util.List;

import com.quhaodian.data.dao.EventInfoDao;
import com.quhaodian.data.dao.EventInfoJoinDao;
import com.quhaodian.data.entity.EventInfo;
import com.quhaodian.data.entity.EventInfoJoin;
import com.quhaodian.data.service.EventInfoJoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;

@Service
@Transactional
public class EventInfoJoinServiceImpl implements EventInfoJoinService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public EventInfoJoin findById(Long id) {
		EventInfoJoin entity = dao.findById(id);
		return entity;
	}

	@Transactional
	public EventInfoJoin save(EventInfoJoin bean) {
		Finder finder = Finder.create();
		finder.append("from EventInfoJoin e where ");
		finder.append("  e.user.id=:userid");
		finder.setParam("userid", bean.getUser().getId());
		finder.append(" and e.eventInfo.id=:eventInfoid");
		finder.setParam("eventInfoid", bean.getEventInfo().getId());

		List list = dao.find(finder);
        if(list!=null&&list.size()>0){
        }else{
    		dao.save(bean);
    		EventInfo info=	eventInfoDao.findById(bean.getEventInfo().getId());
    		if(bean.getType()==1){
    			Integer joins=info.getJoins();
    			if(joins==null){
    				joins=0;
    			}
    			joins++;
    			info.setJoins(joins);
    		}else{
    			Integer favs=info.getFavs();
    			if(favs==null){
    				favs=0;
    			}
    			favs++;
    			info.setFavs(favs);
    		}
        }

		return bean;
	}

	@Transactional
	public EventInfoJoin update(EventInfoJoin bean) {
		Updater<EventInfoJoin> updater = new Updater<EventInfoJoin>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public EventInfoJoin deleteById(Long id) {
		EventInfoJoin bean = dao.deleteById(id);
		return bean;
	}

	@Transactional
	public EventInfoJoin[] deleteByIds(Long[] ids) {
		EventInfoJoin[] beans = new EventInfoJoin[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private EventInfoJoinDao dao;
	@Autowired
	private EventInfoDao eventInfoDao;

	@Autowired
	public void setDao(EventInfoJoinDao dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	@Override
	public Pagination pageByType(int type, int pageNo, int pageSize) {
		Finder finder = Finder.create();
		finder.append("select e.user from EventInfoJoin e where e.type=:typeinfo");
		finder.setParam("typeinfo", type);
		return dao.find(finder, pageNo, pageSize);
	}
	@Transactional(readOnly = true)
	@Override
	public List<EventInfoJoin> pageByMe(long id, long eventid) {
		Finder finder=Finder.create();
		finder.append("from EventInfoJoin e where e.eventInfo.id=:eventid");
		finder.setParam("eventid", eventid);
		finder.append(" and e.user.id =:userid");
		finder.setParam("userid", id);
		finder.setMaxResults(3);
		return dao.find(finder);
	}
	@Transactional(readOnly = true)
	@Override
	public Pagination pageByArea(int areadid, int pageNo, int pageSize) {
		Finder finder=Finder.create();
		finder.append("from EventInfoJoin e where e.eventInfo.area.id=:areadid");
		finder.setParam("areadid", areadid);
		finder.append(" order by e.id desc");
		return dao.find(finder,pageNo,pageSize);
	}
	@Transactional(readOnly = true)
	@Override
	public Pagination pageByType(Long eventid, int type, int pageNo,
			int pageSize) {
		Finder finder = Finder.create();
		finder.append("select e.user from EventInfoJoin e where e.type=:typeinfo");
		finder.setParam("typeinfo", type);
		finder.append(" and e.eventInfo.id = :eventid ");
		finder.setParam("eventid", eventid);
		finder.append("  order by e.id desc ");
		return dao.find(finder, pageNo, pageSize);
	}
	@Transactional(readOnly = true)
	@Override
	public EventInfoJoin findByMe(long id, long eventid) {
		Finder finder=Finder.create();
		finder.append("from EventInfoJoin e where e.eventInfo.id=:eventid");
		finder.setParam("eventid", eventid);
		finder.append(" and e.user.id =:userid");
		finder.setParam("userid", id);
		finder.setMaxResults(3);
		List<EventInfoJoin> lists= dao.find(finder);
		if(lists!=null&&lists.size()>0){
			return lists.get(0);

		}
		return null;
	}
}