package com.openyelp.data.apps;

import java.util.List;

import com.ada.article.data.entity.Article;
import com.ada.article.data.entity.ArticleCatalog;
import com.ada.article.data.service.ArticleCatalogService;
import com.ada.article.data.service.ArticleService;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import com.ada.user.data.entity.UserInfo;

public class ArticleApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArticleService service = ObjectFactory.get().getBean(ArticleService.class);
		for (int i = 0; i < 1000; i++) {
			try {
				System.out.println(i);
				Pageable pager=new Pageable();
				Page<Article> page=	service.page(pager);
				List<Article> as=page.getContent();
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
		area.setLevelInfo(1);
		area.setSortNum(0);
		service.save(area);
	}
	public UserInfo get(){
		
		UserInfo info=new UserInfo();
		return info;
	}

}
