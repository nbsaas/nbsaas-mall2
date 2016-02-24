package com.openyelp.data.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openyelp.data.core.Finder;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;
import com.openyelp.data.dao.EventInfoDao;
import com.openyelp.data.dao.FeedDao;
import com.openyelp.data.entity.EventInfo;
import com.openyelp.data.service.EventInfoService;

@Service
@Transactional
public class EventInfoServiceImpl implements EventInfoService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Finder find=Finder.create("from EventInfo e order by e.id  desc ");
		Pagination page = dao.find(find,pageNo,pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public EventInfo findById(Long id) {
		EventInfo entity = dao.findById(id);
		return entity;
	}

	@Transactional()
	public EventInfo view(Long id) {
		EventInfo entity = dao.findById(id);
		Integer views = entity.getViews();
		if (views == null) {
			views = 0;
		}
		views++;
		entity.setViews(views);
		return entity;
	}

	@Autowired
	FeedDao feedDao;

	@Transactional
	public EventInfo save(EventInfo bean) {
		dao.save(bean);
		feedDao.addFeed(bean);
		return bean;
	}

	@Transactional
	public EventInfo update(EventInfo bean) {
		Updater<EventInfo> updater = new Updater<EventInfo>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public EventInfo deleteById(Long id) {
		EventInfo bean = dao.deleteById(id);
		return bean;
	}

	@Transactional
	public EventInfo[] deleteByIds(Long[] ids) {
		EventInfo[] beans = new EventInfo[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private EventInfoDao dao;

	@Autowired
	public void setDao(EventInfoDao dao) {
		this.dao = dao;
	}

	@Override
	public Pagination pageByRecent(int pageNo, int pageSize) {
		Finder finder = Finder.create();
		finder.append("from  EventInfo e where e.starts_month_day_year > :nowdate");
		finder.setParam("nowdate", new Date());
		finder.append(" order by e.addDate desc");
		return dao.find(finder, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	@Override
	public Pagination pageByMe(long id, int pageNo, int pageSize) {
		Finder finder = Finder.create();
		finder.append("from  EventInfo e where e.user.id=:userid");
		finder.setParam("userid", id);
		finder.append(" and e.starts_month_day_year > :nowdate");
		finder.setParam("nowdate", new Date());
		// TODO Auto-generated method stub
		return dao.find(finder, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	@Override
	public Pagination pageByHot(Integer areaid, int pageNo, int pageSize) {
		Finder finder = Finder.create();
		finder.append("from  EventInfo e where e.starts_month_day_year > :nowdate");
		finder.setParam("nowdate", new Date());
		finder.append(" and  e.area.id = :areaid");
		finder.setParam("areaid", areaid);
		finder.append(" order by e.addDate desc");
		return dao.find(finder, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	@Override
	public Pagination pageByWeek(Integer areaid, int pageNo, int pageSize) {
		Finder finder = Finder.create();
		finder.append("from  EventInfo e where e.starts_month_day_year > :nowdate");
		finder.setParam("nowdate", new Date());
		finder.append(" and  e.area.id = :areaid");
		finder.setParam("areaid", areaid);
		finder.append(" order by e.addDate desc");
		return dao.find(finder, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	@Override
	public Pagination pageByTop(Integer areaid, int pageNo, int pageSize) {
		Finder finder = Finder.create();
		finder.append("from  EventInfo e where e.starts_month_day_year > :nowdate");
		finder.setParam("nowdate", new Date());
		finder.append(" and  e.area.id = :areaid");
		finder.setParam("areaid", areaid);
		finder.append(" order by e.addDate desc");
		return dao.find(finder, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	@Override
	public Pagination pageByGov(Integer areaid, int pageNo, int pageSize) {
		Finder finder = Finder.create();
		finder.append("from  EventInfo e where e.starts_month_day_year > :nowdate");
		finder.setParam("nowdate", new Date());
		finder.append(" and e.community =2");
		finder.append(" and  e.area.id = :areaid");
		finder.setParam("areaid", areaid);
		finder.append(" order by e.starts_month_day_year asc");
		return dao.find(finder, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	@Override
	public Pagination browse(Long areaid, String start_date, String end_date,
			String sort_by, Integer[] c, String[] audience, int curpage,
			int pagesize) {
		Finder finder = Finder.create();
		finder.append("from  EventInfo e where 1=1");
		finder.append(" and  e.area.id = :areaid");
		finder.setParam("areaid", areaid);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date endtime = null;
		try {
			endtime = dateFormat.parse(end_date);
			endtime.setHours(23);
			endtime.setMinutes(59);
			endtime.setSeconds(59);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

		Date starttime = null;
		try {
			starttime = dateFormat.parse(start_date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		if (starttime != null) {
			finder.append(" and  e.starts_month_day_year>= :starttime");
			finder.setParam("starttime", starttime);

		}
		if (endtime != null) {
			finder.append(" and  e.ends_month_day_year>= :endtime");
			finder.setParam("endtime", endtime);

		}

		if ("added".equals(sort_by)) {
			finder.append(" order by e.starts_month_day_year desc");
		} else if ("upcoming".equals(sort_by)) {
			finder.append(" order by e.starts_month_day_year asc");
		} else {
			finder.append(" order by e.joins desc");

		}

		return dao.find(finder, curpage, pagesize);
	}

	@Transactional(readOnly = true)
	@Override
	public Pagination pageByNew(Integer areaid, int pageNo, int pageSize) {
		Finder finder = Finder.create();
		finder.append("from  EventInfo e ");
		finder.append(" where  e.area.id = :areaid");
		finder.setParam("areaid", areaid);
		finder.append(" order by e.addDate desc");
		return dao.find(finder, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	@Override
	public Pagination pageByMeAdd(long id, int pageNo, int pageSize) {
		Finder finder = Finder.create();
		finder.append("from  EventInfo e where e.user.id=:userid");
		finder.setParam("userid", id);
		finder.append(" order by e.id desc");
		// TODO Auto-generated method stub
		return dao.find(finder, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	@Override
	public Pagination pageByJoin(long id, int type, int pageNo, int pageSize) {
		Finder finder = Finder.create();
		finder.append("select e.eventInfo  from EventInfoJoin e where ");
		finder.append("  e.user.id =:userid");
		finder.setParam("userid", id);
		finder.append(" and e.type=:typeinfo");
		finder.setParam("typeinfo", type);
		finder.append(" order by e.id desc");
		// TODO Auto-generated method stub
		return dao.find(finder, pageNo, pageSize);
	}
}