package com.openyelp.article.dao;


import com.openyelp.article.entity.ArticleCatalog;
import com.openyelp.data.core.BaseDao;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;

public interface ArticleCatalogDao extends BaseDao<ArticleCatalog, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public ArticleCatalog findById(Integer id);

	public ArticleCatalog save(ArticleCatalog bean);

	public ArticleCatalog updateByUpdater(Updater<ArticleCatalog> updater);

	public ArticleCatalog deleteById(Integer id);
}