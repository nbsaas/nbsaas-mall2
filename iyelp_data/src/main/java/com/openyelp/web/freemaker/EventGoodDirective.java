package com.openyelp.web.freemaker;

import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.openyelp.data.core.Pagination;
import com.openyelp.data.entity.EventInfo;
import com.openyelp.data.service.EventInfoGoodService;
import com.openyelp.shiro.utils.UserUtil;
import com.openyelp.web.utils.DirectiveUtils;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

public class EventGoodDirective implements TemplateDirectiveModel{

	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars,  
            TemplateDirectiveBody body) throws TemplateException, IOException {

		
		
		 //其实完全可以不用它，params是个Map，自己通过key取值就可以了，做一下空值判断  
        Integer areadid=UserUtil.getCurrentCity().getId();
        Pagination page = goodService.pageByArea(areadid, 1, 1);
        List<EventInfo> infos=(List<EventInfo>) page.getList();
        if(infos!=null&&infos.size()>0){
        	 Map<String, TemplateModel> paramWrap = new HashMap<String, TemplateModel>(params);
     		paramWrap.put("goodEvent", DEFAULT_WRAPPER.wrap(infos.get(0)));
     		Map<String, TemplateModel> origMap = DirectiveUtils
     				.addParamsToVariable(env, paramWrap);
     		if (body != null) {
     			body.render(env.getOut());
     		}
     		DirectiveUtils.removeParamsFromVariable(env, paramWrap, origMap);
        }
       

	}

	@Autowired
	EventInfoGoodService goodService;
}