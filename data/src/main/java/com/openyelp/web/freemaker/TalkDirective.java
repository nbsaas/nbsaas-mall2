package com.openyelp.web.freemaker;

import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ada.data.core.Pagination;
import com.openyelp.data.entity.EventInfo;
import com.openyelp.data.entity.Shop;
import com.openyelp.data.entity.Talk;
import com.openyelp.data.service.EventInfoService;
import com.openyelp.data.service.ShopService;
import com.openyelp.data.service.TalkService;
import com.openyelp.web.utils.DirectiveUtils;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

public class TalkDirective implements TemplateDirectiveModel {

	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {

		Long id = DirectiveUtils.getLong("id", params);

		// 其实完全可以不用它，params是个Map，自己通过key取值就可以了，做一下空值判断
		Talk page = shopService.findById(id);
		Map<String, TemplateModel> paramWrap = new HashMap<String, TemplateModel>(
				params);
		paramWrap.put("onetalk", DEFAULT_WRAPPER.wrap(page));
		Map<String, TemplateModel> origMap = DirectiveUtils
				.addParamsToVariable(env, paramWrap);
		if (body != null) {
			body.render(env.getOut());
		}
		DirectiveUtils.removeParamsFromVariable(env, paramWrap, origMap);

	}

	@Autowired
	TalkService shopService;
}