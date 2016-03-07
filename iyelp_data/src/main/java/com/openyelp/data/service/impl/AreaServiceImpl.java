package com.openyelp.data.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openyelp.data.core.Finder;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;
import com.openyelp.data.dao.AreaDao;
import com.openyelp.data.entity.Area;
import com.openyelp.data.service.AreaService;

@Service
@Transactional
public class AreaServiceImpl implements AreaService {
	
	
	@Cacheable(value="area_cache")
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	
	public Area findById(Integer id) {
		Area entity = dao.findById(id);
		return entity;
	}

	@CacheEvict(value="area_cache",allEntries=true)
	@Transactional
	public Area save(Area bean) {
		dao.save(bean);
		return bean;
	}
	@CacheEvict(value="area_cache",allEntries=true)
	@Transactional
	public Area update(Area bean) {
		Updater<Area> updater = new Updater<Area>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@CacheEvict(value="area_cache",allEntries=true)
	@Transactional
	public Area deleteById(Integer id) {
		Area bean = dao.deleteById(id);
		return bean;
	}

	@CacheEvict(value="area_cache",allEntries=true)
	@Transactional
	public Area[] deleteByIds(Integer[] ids) {
		Area[] beans = new Area[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private AreaDao dao;

	@Autowired
	public void setDao(AreaDao dao) {
		this.dao = dao;
	}

	
	@Cacheable(value="area_cache")
	@Transactional(readOnly = true)
	@Override
	public List<Area> findByLevel(Integer id) {
		// TODO Auto-generated method stub
		return dao.findByProperty("levelinfo", id);
	}

	
	@Transactional(readOnly = true)
	@Override
	public List<Area> findByParent(Integer id) {
		// TODO Auto-generated method stub
		return dao.findByProperty("parent.id", id);
	}

	
	@Cacheable(value="area_cache")
	@Override
	public List<Area> findByHot(Integer id) {
		List<Area> result = null;
		Finder finder = Finder.create();
		finder.append("select h.area from AreaHot h");
		dao.find(finder, 0, id);
		result = (List<Area>) dao.find(finder, 0, id).getList();

		return result;
	}

	
	@Cacheable(value="area_cache")
	@Transactional(readOnly = true)
	@Override
	public Area findByName(String name) {

		Area resultone = null;

		List<Area> result = null;
		Finder finder = Finder.create();
		finder.append(" from Area a  where a.name=:name");
		finder.setParam("name", name);
		result = dao.find(finder);
		if (result != null && result.size() > 0) {
			resultone = result.get(0);
		}
		return resultone;
	}

	
	@Cacheable(value="area_cache")
	@Transactional(readOnly = true)
	@Override
	public Area findByNames(String name) {
		Area resultone = null;
		name = "%" + name + "%";
		List<Area> result = null;
		Finder finder = Finder.create();
		finder.append(" from Area a  where a.name  like :name");
		finder.setParam("name", name);
		result = dao.find(finder);
		if (result != null && result.size() > 0) {
			resultone = result.get(0);
		}
		return resultone;
	}

	
	@Cacheable(value="area_cache")
	@Transactional(readOnly = true)
	@Override
	public List<Area> findByChild(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Transactional(readOnly = true)
	@Override
	public List<Area> findByTops(Integer id) {
		LinkedList<Area> areas = new LinkedList<Area>();
		int areaid = id;
		Area area = dao.findById(id);
		while (area.getParent()!=null&&area.getParent().getId() > 0) {
			areas.addFirst(area);
			area=dao.findById(area.getParentId());
		}

		return areas;
	}

	
	
	@Cacheable(value="area_cache")
	@Transactional(readOnly = true)
	@Override
	public Pagination pageByLevel(int level, int pageNo, int pageSize) {
		Finder finder=Finder.create();
		finder.append("from Area a where a.levelinfo =:levelinfo");
		finder.setParam("levelinfo", level);
		finder.append(" order by a.id desc ");
		return dao.find(finder, pageNo, pageSize);
	}

	
	
	@Cacheable(value="area_cache")
	@Transactional(readOnly = true)
	@Override
	public Pagination pageByLevel(Integer areaid, int level, int pageNo,
			int pageSize) {
		Area area=dao.findById(areaid);
		
		Finder finder=Finder.create();
		finder.append("from Area a where a.levelinfo =:levelinfo");
		finder.setParam("levelinfo", level);
		if(area!=null){
			finder.append(" and a.lft>="+area.getLft());
			finder.append(" and a.rgt<="+area.getRgt());
		}
		finder.append(" order by a.id desc ");
		
		
		return dao.find(finder, pageNo, pageSize);
	}
	
	
	@Cacheable(value="area_cache")
	@Transactional(readOnly = true)
	@Override
	public Pagination pageByLevelState(int level, int state, int pageNo,
			int pageSize) {
		Finder finder=Finder.create();
		finder.append("from Area a where a.levelinfo =:levelinfo");
		finder.setParam("levelinfo", level);
		finder.append(" and a.state =:state");
		finder.setParam("state", state);
		finder.append(" order by a.id desc ");
		return dao.find(finder, pageNo, pageSize);
	}

}