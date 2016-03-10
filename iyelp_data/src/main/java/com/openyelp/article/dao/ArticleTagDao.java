package com.openyelp.article.dao;


import com.openyelp.article.entity.ArticleTag;
import com.ada.data.core.BaseDao;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;

public interface ArticleTagDao extends BaseDao<ArticleTag, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public ArticleTag findById(Long id);

	public ArticleTag save(ArticleTag bean);

	public ArticleTag updateByUpdater(Updater<ArticleTag> updater);

	public ArticleTag deleteById(Long id);
}