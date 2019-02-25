package com.haoxuer.haodian.web.freemaker;

import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.haoxuer.haodian.data.entity.Shop;
import com.haoxuer.haodian.data.service.ShopService;
import com.haoxuer.haodian.web.utils.DirectiveUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.haoxuer.discover.data.core.Pagination;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

public class ShopNearDirective implements TemplateDirectiveModel{

	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars,  
            TemplateDirectiveBody body) throws TemplateException, IOException {

		Integer size = DirectiveUtils.getInt("size", params);
		Integer id = DirectiveUtils.getInt("id", params);  

		 //其实完全可以不用它，params是个Map，自己通过key取值就可以了，做一下空值判断  
        Pagination page = shopService.pageByNear(id, 1, size);
        List<Shop> infos=(List<Shop>) page.getList();
        if(infos!=null&&infos.size()>0){
        	 Map<String, TemplateModel> paramWrap = new HashMap<String, TemplateModel>(params);
     		paramWrap.put("shops", DEFAULT_WRAPPER.wrap(infos));
     		Map<String, TemplateModel> origMap = DirectiveUtils
     				.addParamsToVariable(env, paramWrap);
     		if (body != null) {
     			body.render(env.getOut());
     		}
     		DirectiveUtils.removeParamsFromVariable(env, paramWrap, origMap);
        }
       

	}

	@Autowired
  ShopService shopService;
}