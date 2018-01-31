package com.quhaodian.haodian.data.service.impl;

import java.util.List;

import com.quhaodian.haodian.data.dao.EntityContentDao;
import com.quhaodian.haodian.data.service.EntityContentService;
import com.quhaodian.haodian.data.entity.EntityContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quhaodian.data.core.Finder;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;

@Service
@Transactional
public class EntityContentServiceImpl implements EntityContentService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public EntityContent findById(Integer id) {
		EntityContent entity = dao.findById(id);
		return entity;
	}

	@Transactional
	public EntityContent save(EntityContent bean) {

		List<EntityContent> cs = dao.findByProperty("title", bean.getTitle());
		if (cs == null || cs.size() == 0) {
			dao.save(bean);
		} else {

		}
		return bean;
	}

	@Transactional
	public EntityContent update(EntityContent bean) {
		Updater<EntityContent> updater = new Updater<EntityContent>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Transactional
	public EntityContent deleteById(Integer id) {
		EntityContent bean = dao.deleteById(id);
		return bean;
	}

	@Transactional
	public EntityContent[] deleteByIds(Integer[] ids) {
		EntityContent[] beans = new EntityContent[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private EntityContentDao dao;

	@Autowired
	public void setDao(EntityContentDao dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	@Override
	public EntityContent findByRandom(Integer id) {
		EntityContent result = null;
		Finder f = Finder.create();
		f.append("from  EntityContent e");
		f.append(" where e.id <" + id);
		f.append(" order by e.id desc");
		Pagination p = dao.find(f, 1, 2);
		if (p != null) {
			List<EntityContent> cs = (List<EntityContent>) p.getList();
			if (cs != null && cs.size() > 0) {
				result = cs.get(0);
			}
		}
		return result;
	}

	@Override
	public int all() {
		Finder f = Finder.create();
		f.append("from  EntityContent e");
		int x=dao.countQueryResult(f);
		return x;
	}
}