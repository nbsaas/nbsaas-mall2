package com.quhaodian.web.freemaker;

import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.quhaodian.shiro.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;

import com.ada.area.data.entity.Area;
import com.ada.area.data.service.AreaService;
import com.quhaodian.web.utils.DirectiveUtils;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

public class HotAreaDirective implements TemplateDirectiveModel{

	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars,  
            TemplateDirectiveBody body) throws TemplateException, IOException {

		
		
		 //其实完全可以不用它，params是个Map，自己通过key取值就可以了，做一下空值判断  
        Integer size = DirectiveUtils.getInt("size", params);  

        List<Area> page = areaService.list(0,size,null,null);
        
        Map<String, TemplateModel> paramWrap = new HashMap<String, TemplateModel>(params);
		paramWrap.put("list", DEFAULT_WRAPPER.wrap(page));
		paramWrap.put("city", DEFAULT_WRAPPER.wrap(UserUtil.getCurrentCity()));

		Map<String, TemplateModel> origMap = DirectiveUtils
				.addParamsToVariable(env, paramWrap);
		if (body != null) {
			body.render(env.getOut());
		}
		DirectiveUtils.removeParamsFromVariable(env, paramWrap, origMap);

	}

	@Autowired
	AreaService areaService;
}