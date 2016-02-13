package com.openyelp.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openyelp.data.core.Finder;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;
import com.openyelp.data.dao.AreaDao;
import com.openyelp.data.dao.FeedDao;
import com.openyelp.data.entity.Area;
import com.openyelp.data.entity.Feed;
import com.openyelp.data.entity.ShopCategory;
import com.openyelp.data.service.FeedService;

@Service
@Transactional
public class FeedServiceImpl implements FeedService {
	@Transactional(readOnly = true)
	public Pagination<Feed>  getPage(int pageNo, int pageSize) {
		Pagination<Feed>  page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public Feed findById(Long id) {
		Feed entity = dao.findById(id);
		return entity;
	}

	@Transactional
	public Feed save(Feed bean) {
		dao.save(bean);
		return bean;
	}

	@Transactional
	public Feed update(Feed bean) {
		Updater<Feed> updater = new Updater<Feed>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}
	@CacheEvict(allEntries = true,value="feed_cache")
	@Transactional
	public Feed deleteById(Long id) {
		Feed bean = dao.deleteById(id);
		return bean;
	}

	@CacheEvict(allEntries = true,value="feed_cache")
	@Transactional
	public Feed[] deleteByIds(Long[] ids) {
		Feed[] beans = new Feed[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private FeedDao dao;

	@Autowired
	public void setDao(FeedDao dao) {
		this.dao = dao;
	}

	@Autowired
	AreaDao areaDao;

	
	@Override
	public Pagination<Feed>  pageByArea(int areaid, int pageNo, int pageSize) {

		Area area = areaDao.findById(areaid);

		if (area != null) {
			Finder finder = Finder.create();
			finder.append("select distinct  s from Feed s ");

			finder.append(" where s.area.lft   >=:arealft");
			finder.append(" and s.area.rgt   <=:areargt");
			finder.setParam("arealft", area.getLft());
			finder.setParam("areargt", area.getRgt());
			finder.append(" order by s.id desc");
			Pagination p = null;
			try {
				p = dao.find(finder, pageNo, pageSize);
				// System.out.println(dao.transHqlToSql(finder.getOrigHql()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return p;
		} else {
			return null;
		}

	}
	@Override
	public Pagination<Feed>  pageByFollow(long userid, int pageNo, int pageSize) {
		Finder finder = Finder.create();
		finder.append("select distinct f from Feed f,UserFollow u");
		finder.append(" where u.user.id=:uid");
		finder.setParam("uid", userid);
		finder.append(" and  u.friend.id=f.user.id");

		finder.append(" order by f.id desc");
		Pagination<Feed> p = null;
		p = dao.find(finder, pageNo, pageSize);
		return p;
	}

	@Override
	public Pagination<Feed>  pageByUser(long userid, int pageNo, int pageSize) {
		Finder finder = Finder.create();
		finder.append(" from Feed f");
		finder.append(" where f.user.id=:uid");
		finder.setParam("uid", userid);
		finder.append(" order by f.id desc");
		Pagination<Feed> p = null;
		p = dao.find(finder, pageNo, pageSize);
		return p;
	}

	@Override
	public Pagination<Feed>  pageByFriend(long userid, int pageNo, int pageSize) {
		Finder finder = Finder.create();
		finder.append("select distinct f from Feed f,UserFriend u");
		finder.append(" where u.user.id=:uid");
		finder.setParam("uid", userid);
		finder.append(" and  u.friend.id=f.user.id");

		finder.append(" order by f.id desc");
		Pagination<Feed> p = null;
		p = dao.find(finder, pageNo, pageSize);
		return p;
	}
}