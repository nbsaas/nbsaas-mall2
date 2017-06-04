package com.quhaodian.data.apps;

import com.ada.article.entity.Article;
import com.ada.article.entity.ArticleCatalog;
import com.ada.article.entity.SensitiveCategory;
import com.ada.data.entity.CatalogEntity;
import com.ada.imake.ChainMake;
import com.ada.imake.template.hibernate.TemplateHibernateDir;
import com.ada.imake.templates.simple.TemplateSimpleDir;

import java.io.File;

public class MakeApps {

	public static void main(String[] args) {

		File file = new File("D:\\mvnspace\\iyelp\\web\\src\\main\\webapp\\WEB-INF\\ftl\\admin");
		ChainMake make = new ChainMake(TemplateSimpleDir.class, TemplateHibernateDir.class);
		make.setAction("com.quhaodian.actions.admin");
		make.setView(file);
		make.setDao(false);
		make.setService(false);
		make.setAction(true);
		make.setView(true);
		make.setMenus("1,57,58");
		// UserOauthToken.
		 make.makes(ArticleCatalog.class);
		// make.makes(UserOschina.class,UserOauthWeibo.class,UserQQ.class,UserGitHub.class);
		// new ChainMake().makes("com.ada.imakedemo.data.entity");

		Class<?> c = SensitiveCategory.class;
		Class<?> b = CatalogEntity.class;
		if (c.getSuperclass().equals(b)) {
			System.out.println("h");
		}


	}

}
