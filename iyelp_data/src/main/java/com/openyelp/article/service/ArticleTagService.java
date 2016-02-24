package com.openyelp.article.service;

import com.openyelp.annotation.RestFul;
import com.openyelp.article.entity.ArticleTag;
import com.openyelp.data.core.Pagination;



@RestFul(api=ArticleTagService.class,value="ArticleTagService")
public interface ArticleTagService {
	public Pagination getPage(int pageNo, int pageSize);

	public ArticleTag findById(Long id);

	public ArticleTag save(ArticleTag bean);

	public ArticleTag update(ArticleTag bean);

	public ArticleTag deleteById(Long id);
	
	public ArticleTag[] deleteByIds(Long[] ids);
}