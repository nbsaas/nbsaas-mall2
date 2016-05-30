package com.openyelp.data.apps;

import java.util.List;

import com.ada.article.entity.Article;
import com.ada.article.entity.ArticleCatalog;
import com.ada.article.page.ArticlePage;
import com.ada.article.service.ArticleCatalogService;
import com.ada.article.service.ArticleService;
import com.ada.user.entity.UserInfo;

public class ArticleApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArticleService service = ObjectFactory.get().getBean(ArticleService.class);
		for (int i = 0; i < 1000; i++) {
			try {
				System.out.println(i);
				ArticlePage page=	service.pageByCatalog(2, 1, 10);
				List<Article> as=page.getList();
				for (Article article : as) {
					System.out.println(article);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
	
		
	}
	private static void ad() {
		ArticleCatalogService service = ObjectFactory.get().getBean(ArticleCatalogService.class);
		ArticleCatalog area=new ArticleCatalog();
		area.setName("文章分类");
		area.setLevelinfo(1);
		area.setSortnum(0);
		service.save(area);
	}
	public UserInfo get(){
		
		UserInfo info=new UserInfo();
		return info;
	}

}
