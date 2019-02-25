package com.quhaodian.haodian.web.freemaker;

import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.quhaodian.haodian.data.service.TalkService;
import com.quhaodian.haodian.shiro.utils.UserUtil;
import com.quhaodian.haodian.web.utils.DirectiveUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.haoxuer.discover.data.core.Pagination;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

public class TalkNewsDirective implements TemplateDirectiveModel{

	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars,  
            TemplateDirectiveBody body) throws TemplateException, IOException {

		
		
		 //其实完全可以不用它，params是个Map，自己通过key取值就可以了，做一下空值判断  
        Integer size = DirectiveUtils.getInt("size", params);
        Pagination page  = talkService.findByCity(UserUtil.getCurrentCity().getId(), -1, 1, size);
        List list= page.getList(); 
        Map<String, TemplateModel> paramWrap = new HashMap<String, TemplateModel>(params);
		paramWrap.put("list", DEFAULT_WRAPPER.wrap(list));
		Map<String, TemplateModel> origMap = DirectiveUtils
				.addParamsToVariable(env, paramWrap);
		if (body != null) {
			body.render(env.getOut());
		}
		DirectiveUtils.removeParamsFromVariable(env, paramWrap, origMap);

	}

	@Autowired
    TalkService talkService;
}