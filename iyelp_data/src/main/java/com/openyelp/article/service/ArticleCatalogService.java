package com.openyelp.article.service;

import java.util.List;

import com.openyelp.annotation.RestFul;
import com.openyelp.article.entity.ArticleCatalog;
import com.openyelp.data.core.Pagination;



@RestFul(api=ArticleCatalogService.class,value="ArticleCatalogService")
public interface ArticleCatalogService {
	public Pagination getPage(int pageNo, int pageSize);

	public ArticleCatalog findById(Integer id);

	public ArticleCatalog save(ArticleCatalog bean);

	public ArticleCatalog update(ArticleCatalog bean);

	public ArticleCatalog deleteById(Integer id);
	
	public ArticleCatalog[] deleteByIds(Integer[] ids);
	
	List<ArticleCatalog> findChild(int id);
	
	public Pagination pageByPid(int  pid,int pageNo, int pageSize);


}