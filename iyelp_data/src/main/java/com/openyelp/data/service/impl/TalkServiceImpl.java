package com.openyelp.data.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openyelp.data.core.Finder;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;
import com.openyelp.data.dao.AreaDao;
import com.openyelp.data.dao.FeedDao;
import com.openyelp.data.dao.TalkCategoryAreaDao;
import com.openyelp.data.dao.TalkCategoryDao;
import com.openyelp.data.dao.TalkDao;
import com.openyelp.data.entity.Area;
import com.openyelp.data.entity.Talk;
import com.openyelp.data.entity.TalkCategory;
import com.openyelp.data.entity.TalkCategoryArea;
import com.openyelp.data.service.TalkService;

@Service
@Transactional
public class TalkServiceImpl implements TalkService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public Talk findById(Long id) {
		Talk entity = dao.findById(id);
		return entity;
	}
	
	@Autowired
	FeedDao feedDao;

	@Transactional
	public Talk save(Talk bean) {
		bean.setLastmessage(bean.getMessage());
		dao.save(bean);
	
		return bean;
	}

	@Transactional
	public Talk update(Talk bean) {
		Updater<Talk> updater = new Updater<Talk>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public Talk deleteById(Long id) {
		Talk bean = dao.deleteById(id);
		return bean;
	}

	@Transactional
	public Talk[] deleteByIds(Long[] ids) {
		Talk[] beans = new Talk[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private TalkDao dao;

	@Autowired
	public void setDao(TalkDao dao) {
		this.dao = dao;
	}

	@Autowired
	TalkCategoryAreaDao talkCategoryAreaDao;

	@Autowired
	TalkCategoryDao talkCategoryDao;

	@Autowired
	AreaDao areaDao;
	@Transactional
	@Override
	public Talk add(Talk talk, int catalog, String city) {
		Talk result = null;
		talk.setLastmessage(talk.getMessage());

		Finder finderarea = Finder.create();
		finderarea.append("from Area a where a.name=:name and levelinfo=3");
		finderarea.setParam("name", city);
		List<Area> as = areaDao.find(finderarea);
		if (as != null && as.size() > 0) {
			Area cityarea = as.get(0);
			Finder finder = Finder.create();
			finder.append("from TalkCategoryArea t where t.area.id=:areaid");
			finder.append(" and t.talkCategory.id =:tid");
			finder.setParam("areaid", cityarea.getId());
			finder.setParam("tid", catalog);

			List<TalkCategoryArea> tas = talkCategoryAreaDao.find(finder);
			if (tas != null && tas.size() > 0) {
				TalkCategoryArea a = tas.get(0);
				a.setLastDate(new Date());
				Integer size = a.getSize();
				if(size==null){
					size=0;
				}
				size++;
				a.setSize(size);
				talk.setArea(a);
				result = dao.save(talk);
				feedDao.addFeed(talk);

			} else {
				TalkCategoryArea t = new TalkCategoryArea();
				t.setArea(cityarea);
				t.setAddDate(new Date());
				t.setLastDate(new Date());
				TalkCategory talkCategory = new TalkCategory();
				talkCategory.setId(catalog);
				t.setTalkCategory(talkCategory);
				t.setSize(1);
				talkCategoryAreaDao.save(t);
				
				talk.setArea(t);
				result = dao.save(talk);
				feedDao.addFeed(talk);
			}
		} else {
			result = new Talk();
			result.setId(-1l);
		}

		return result;
	}
	
	@Transactional(readOnly = true)
	@Override
	public Pagination findByCity(int cityid,int category, int pageNo, int pageSize) {
		Finder finder =Finder.create();
		finder.append("from Talk t where  t.area.area.id=:cityid");
		finder.setParam("cityid", cityid);
		if(category>0){
			finder.append(" and  t.area.id=:category");
			finder.setParam("category", category);
		}
		finder.append(" order by t.id desc");
		return dao.find(finder , pageNo, pageSize);
	}

	
	@Transactional(readOnly = true)
	@Override
	public Pagination findByCity(int cityid, int category, long userid,
			int pageNo, int pageSize) {
		Finder finder =Finder.create();
		finder.append("from Talk t where  t.area.area.id=:cityid");
		finder.setParam("cityid", cityid);
		if(category>0){
			finder.append(" and  t.area.id=:category");
			finder.setParam("category", category);
		}
		finder.append(" and  t.user.id=:userid");
		finder.setParam("userid", userid);
		finder.append(" order by t.id desc");
		return dao.find(finder , pageNo, pageSize);
	}
	@Transactional(readOnly = true)
	@Override
	public Pagination page(int curpage, int pagesize) {
		Finder finder =Finder.create();
		finder.append("from Talk t   order by t.id desc");
		return dao.find(finder , curpage, pagesize);
	}
}