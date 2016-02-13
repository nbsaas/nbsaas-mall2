package com.openyelp.article.service;

import com.openyelp.annotation.RestFul;
import com.openyelp.article.entity.Article;
import com.openyelp.article.page.ArticlePage;
import com.openyelp.data.core.Pagination;



@RestFul(api=ArticleService.class,value="ArticleService")
public interface ArticleService {
	public Pagination getPage(int pageNo, int pageSize);

	public Article findById(Long id);

	public Article save(Article bean);

	public Article update(Article bean);

	public Article deleteById(Long id);
	
	public Article[] deleteByIds(Long[] ids);
	
	public ArticlePage pageByCatalog(int catalog,int pageNo, int pageSize);
	
	public ArticlePage pageByCatalog(long uid,int catalog,int pageNo, int pageSize);


}