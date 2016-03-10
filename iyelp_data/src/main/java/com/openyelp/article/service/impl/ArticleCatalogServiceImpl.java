package com.openyelp.article.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openyelp.article.dao.ArticleCatalogDao;
import com.openyelp.article.entity.ArticleCatalog;
import com.openyelp.article.service.ArticleCatalogService;
import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;

@Service
@Transactional
public class ArticleCatalogServiceImpl implements ArticleCatalogService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public ArticleCatalog findById(Integer id) {
		ArticleCatalog entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public ArticleCatalog save(ArticleCatalog bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public ArticleCatalog update(ArticleCatalog bean) {
		Updater<ArticleCatalog> updater = new Updater<ArticleCatalog>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public ArticleCatalog deleteById(Integer id) {
		ArticleCatalog bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public ArticleCatalog[] deleteByIds(Integer[] ids) {
		ArticleCatalog[] beans = new ArticleCatalog[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private ArticleCatalogDao dao;

	@Autowired
	public void setDao(ArticleCatalogDao dao) {
		this.dao = dao;
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<ArticleCatalog> findChild(int id) {
		Finder finder = Finder.create("from ArticleCatalog t where t.parent.id=" + id);
		finder.append(" order by t.sortnum asc");
		finder.setCacheable(true);
		return dao.find(finder);
	}

	@Transactional(readOnly = true)
	@Override
	public Pagination pageByPid(int pid, int pageNo, int pageSize) {
		Finder finder = Finder.create("from ArticleCatalog t where t.parent.id=" + pid);
		finder.append(" order by t.sortnum asc");
		finder.setCacheable(true);
		return dao.find(finder, pageNo, pageSize);
	}
}