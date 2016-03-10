package com.openyelp.article.dao;


import com.openyelp.article.entity.Article;
import com.ada.data.core.BaseDao;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;

public interface ArticleDao extends BaseDao<Article, Long>{
	public Pagination getPage(int pageNo, int pageSize);

	public Article findById(Long id);

	public Article save(Article bean);

	public Article updateByUpdater(Updater<Article> updater);

	public Article deleteById(Long id);
}