package com.openyelp.article.page;

import com.openyelp.article.entity.Article;
import com.ada.data.core.Pagination;

public class ArticlePage extends PageRpc<Article> {

	public ArticlePage(Pagination page) {
		super(page);
	}

}
