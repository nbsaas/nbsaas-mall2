package com.openyelp.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openyelp.data.core.Finder;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;
import com.openyelp.data.dao.TalkCategoryDao;
import com.openyelp.data.entity.TalkCategory;
import com.openyelp.data.service.TalkCategoryService;

@Service
@Transactional
public class TalkCategoryServiceImpl implements TalkCategoryService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public TalkCategory findById(Integer id) {
		TalkCategory entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public TalkCategory save(TalkCategory bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public TalkCategory update(TalkCategory bean) {
		Updater<TalkCategory> updater = new Updater<TalkCategory>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public TalkCategory deleteById(Integer id) {
		TalkCategory bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public TalkCategory[] deleteByIds(Integer[] ids) {
		TalkCategory[] beans = new TalkCategory[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private TalkCategoryDao dao;

	@Autowired
	public void setDao(TalkCategoryDao dao) {
		this.dao = dao;
	}
	
	
	@Transactional(readOnly = true)
	@Override
	public List<TalkCategory> findByCity(Integer id) {
		Finder finder=Finder.create();
		finder.append("select t.area from TalkCategoryArea t where t.area.id =:tid");
		finder.setParam("tid", id);
		return dao.find(finder);
	}
	@Transactional(readOnly = true)
	@Override
	public List<TalkCategory> findByPid(int id) {
		Finder finder=Finder.create();
		finder.append("from TalkCategory t where t.parent.id =:tid");
		finder.setParam("tid", id);
		return dao.find(finder);
	}
}