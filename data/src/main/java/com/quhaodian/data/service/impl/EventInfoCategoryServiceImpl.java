package com.quhaodian.data.service.impl;

import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Updater;
import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Order;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import com.quhaodian.data.dao.EventInfoCategoryDao;
import com.quhaodian.data.entity.EventInfoCategory;
import com.quhaodian.data.service.EventInfoCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class EventInfoCategoryServiceImpl implements EventInfoCategoryService {
	

	@Transactional(readOnly = true)
	public EventInfoCategory findById(Integer id) {
		EventInfoCategory entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public EventInfoCategory save(EventInfoCategory bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public EventInfoCategory update(EventInfoCategory bean) {
		Updater<EventInfoCategory> updater = new Updater<EventInfoCategory>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public EventInfoCategory deleteById(Integer id) {
		EventInfoCategory bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public EventInfoCategory[] deleteByIds(Integer[] ids) {
		EventInfoCategory[] beans = new EventInfoCategory[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private EventInfoCategoryDao dao;

	@Autowired
	public void setDao(EventInfoCategoryDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	public Page<EventInfoCategory> getPage(int pageNo, int pageSize) {
		Page<EventInfoCategory> result = null;
		Finder finder=Finder.create();
		finder.append("from EventInfoCategory f ");
		finder.append(" order by f.id desc  ");
		Pageable pager=new Pageable();
		return dao.page(pager);
	}
	
	
	@Transactional(readOnly = true)
	public Page<EventInfoCategory> findPage(Pageable pageable){
	     return dao.findPage(pageable);
	}

	@Transactional(readOnly = true)
	public long count(Filter... filters){
	     
	     return dao.count(filters);
	     
	}

	@Transactional(readOnly = true)
	public List<EventInfoCategory> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders){
	
		     return dao.findList(first,count,filters,orders);
	
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<EventInfoCategory> findByPid(Integer id) {
		Finder finder=Finder.create();
		finder.append("from EventInfoCategory c where c.parent.id =:pid");
		finder .append(" order by c.sortnum asc ");
		finder.setParam("pid", id);
		return dao.find(finder);
	}
	
}