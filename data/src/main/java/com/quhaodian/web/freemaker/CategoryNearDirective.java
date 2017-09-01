package com.quhaodian.web.freemaker;

import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ada.data.core.Pagination;
import com.quhaodian.data.service.ShopCategoryService;
import com.quhaodian.web.utils.DirectiveUtils;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

public class CategoryNearDirective implements TemplateDirectiveModel{

	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars,  
            TemplateDirectiveBody body) throws TemplateException, IOException {

		Integer size = DirectiveUtils.getInt("size", params);  
		Long id = DirectiveUtils.getLong("id", params);  

		 //其实完全可以不用它，params是个Map，自己通过key取值就可以了，做一下空值判断  
        Pagination page = shopService.pageByNear(id, 1, size);
        List infos= page.getList();
        if(infos!=null&&infos.size()>0){
        	 Map<String, TemplateModel> paramWrap = new HashMap<String, TemplateModel>(params);
     		paramWrap.put("categorys", DEFAULT_WRAPPER.wrap(infos));
     		Map<String, TemplateModel> origMap = DirectiveUtils
     				.addParamsToVariable(env, paramWrap);
     		if (body != null) {
     			body.render(env.getOut());
     		}
     		DirectiveUtils.removeParamsFromVariable(env, paramWrap, origMap);
        }
       

	}

	@Autowired
	ShopCategoryService shopService;
}