package com.haoxuer.haodian.data.service.impl;

import java.util.List;

import com.haoxuer.haodian.data.service.TalkCategoryAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Finder;
import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.haodian.data.dao.TalkCategoryAreaDao;
import com.haoxuer.haodian.data.entity.TalkCategoryArea;

@Service
@Transactional
public class TalkCategoryAreaServiceImpl implements TalkCategoryAreaService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public TalkCategoryArea findById(Integer id) {
		TalkCategoryArea entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public TalkCategoryArea save(TalkCategoryArea bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public TalkCategoryArea update(TalkCategoryArea bean) {
		Updater<TalkCategoryArea> updater = new Updater<TalkCategoryArea>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public TalkCategoryArea deleteById(Integer id) {
		TalkCategoryArea bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public TalkCategoryArea[] deleteByIds(Integer[] ids) {
		TalkCategoryArea[] beans = new TalkCategoryArea[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private TalkCategoryAreaDao dao;

	@Autowired
	public void setDao(TalkCategoryAreaDao dao) {
		this.dao = dao;
	}
	
	
	@Transactional(readOnly = true)
	@Override
	public List<TalkCategoryArea> findByCity(Integer id) {
		Finder finder=Finder.create();
		finder.append("from TalkCategoryArea t where t.area.id =:tid");
		finder.setParam("tid", id);
		return dao.find(finder);
	}
}