package com.openyelp.article.service;

import com.openyelp.annotation.RestFul;
import com.openyelp.article.entity.ArticleComment;
import com.openyelp.article.page.ArticleCommentPage;
import com.openyelp.data.core.Pagination;



@RestFul(api=ArticleCommentService.class,value="ArticleCommentService")
public interface ArticleCommentService {
	public Pagination getPage(int pageNo, int pageSize);

	public ArticleComment findById(Long id);

	public ArticleComment save(ArticleComment bean);

	public ArticleComment update(ArticleComment bean);

	public ArticleComment deleteById(Long id);
	
	public ArticleComment[] deleteByIds(Long[] ids);
	public ArticleCommentPage pageByArticle(Long articleid,int pageNo, int pageSize);
}