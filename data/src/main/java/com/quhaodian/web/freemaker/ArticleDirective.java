package com.quhaodian.web.freemaker;

import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.ada.article.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;

import com.ada.article.page.ArticlePage;
import com.ada.article.service.ArticleService;
import com.quhaodian.web.utils.DirectiveUtils;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

public class ArticleDirective implements TemplateDirectiveModel{

	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars,  
            TemplateDirectiveBody body) throws TemplateException, IOException {

		
		
		Integer size = DirectiveUtils.getInt("size", params); 
		if (size==null) {
			size=10;
		}
		Integer id = DirectiveUtils.getInt("id", params);  

        Map<String, TemplateModel> paramWrap = new HashMap<String, TemplateModel>(params);
		ArticlePage page = articleService.pageByCatalog(id, 1, size);
		if (page!=null){
			paramWrap.put("list", DEFAULT_WRAPPER.wrap(page.getList()));
		}else {
			paramWrap.put("list", DEFAULT_WRAPPER.wrap(new ArrayList<Article>()));

		}
		Map<String, TemplateModel> origMap = DirectiveUtils
				.addParamsToVariable(env, paramWrap);
		if (body != null) {
			body.render(env.getOut());
		}
		DirectiveUtils.removeParamsFromVariable(env, paramWrap, origMap);

	}

	@Autowired
	ArticleService articleService;
}