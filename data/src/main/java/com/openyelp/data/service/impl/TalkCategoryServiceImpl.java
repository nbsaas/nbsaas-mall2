package com.openyelp.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.openyelp.data.dao.TalkCategoryDao;
import com.openyelp.data.entity.TalkCategory;
import com.openyelp.data.service.TalkCategoryService;
import com.openyelp.data.page.TalkCategoryPage;

import com.ada.data.page.Filter;
import com.ada.data.page.Order;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import java.util.List;


@Service
@Transactional
public class TalkCategoryServiceImpl implements TalkCategoryService {
	

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
	public TalkCategoryPage getPage(int pageNo, int pageSize) {
	    TalkCategoryPage result = null;
		Finder finder=Finder.create();
		finder.append("from TalkCategory f ");
		finder.append(" order by f.id desc  ");
		Pagination<TalkCategory> page = dao.find(finder,pageNo, pageSize);
		result = new TalkCategoryPage(page);
		return result;
	}
	
	
	@Transactional(readOnly = true)
	public Page<TalkCategory> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<TalkCategory> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
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