package com.openyelp.article.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openyelp.article.dao.ArticleCatalogDao;
import com.openyelp.article.dao.ArticleDao;
import com.openyelp.article.entity.Article;
import com.openyelp.article.entity.ArticleCatalog;
import com.openyelp.article.page.ArticlePage;
import com.openyelp.article.service.ArticleService;
import com.openyelp.data.core.Finder;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}
    @Cacheable(value="articlecache")
	@Transactional(readOnly = true)
	public Article findById(Long id) {
		Article entity = dao.findById(id);
		return entity;
	}
	@CacheEvict(allEntries = true,value="articlecache")
	@Transactional
	public Article save(Article bean) {
		dao.save(bean);
		return bean;
	}
	@CacheEvict(allEntries = true,value="articlecache")
	@Transactional
	public Article update(Article bean) {
		Updater<Article> updater = new Updater<Article>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}
	@CacheEvict(allEntries = true,value="articlecache")
	@Transactional
	public Article deleteById(Long id) {
		Article bean = dao.deleteById(id);
		return bean;
	}
	@CacheEvict(allEntries = true,value="articlecache")
	@Transactional
	public Article[] deleteByIds(Long[] ids) {
		Article[] beans = new Article[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private ArticleDao dao;

	@Autowired
	private ArticleCatalogDao catalogDao;

	@Autowired
	public void setDao(ArticleDao dao) {
		this.dao = dao;
	}
    @Cacheable(value="articlecache")
	@Transactional(readOnly = true)
	@Override
	public ArticlePage pageByCatalog(int catalog, int pageNo, int pageSize) {
		ArticlePage result = null;

		ArticleCatalog catalogs = catalogDao.findById(catalog);
		if (catalogs != null) {
			Finder finder = Finder.create();
			finder.append("from Article a where a.catalog.lft >= :lft ");
			finder.setParam("lft", catalogs.getLft());
			finder.append(" and a.catalog.rgt <= :rgt");
			finder.setParam("rgt", catalogs.getRgt());
			Pagination<Article> page = dao.find(finder, pageNo, pageSize);
			result = new ArticlePage(page);
		}
		return result;
	}

    @Cacheable(value="articlecache")
	@Transactional(readOnly = true)
	@Override
	public ArticlePage pageByCatalog(long uid, int catalog, int pageNo,
			int pageSize) {
		ArticlePage result = null;

		ArticleCatalog catalogs = catalogDao.findById(catalog);
		if (catalogs != null) {
			Finder finder = Finder.create();
			finder.append("from Article a where a.catalog.lft >= :lft ");
			finder.setParam("lft", catalogs.getLft());
			finder.append(" and a.catalog.rgt <= :rgt");
			finder.setParam("rgt", catalogs.getRgt());
			finder.append("  and a.user.id =:uid");
			finder.setParam("uid", uid);
			finder.append("  order by a.id desc  ");
			Pagination<Article> page = dao.find(finder, pageNo, pageSize);
			result = new ArticlePage(page);
		}
		return result;
	}
}