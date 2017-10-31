package com.quhaodian.web.freemaker;

import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.quhaodian.data.entity.ShopImageList;
import com.quhaodian.data.service.ShopImageListService;
import org.springframework.beans.factory.annotation.Autowired;

import com.quhaodian.web.utils.DirectiveUtils;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

public class ShopImageListDirective implements TemplateDirectiveModel {

	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {

		Long id = DirectiveUtils.getLong("id", params);

		// 其实完全可以不用它，params是个Map，自己通过key取值就可以了，做一下空值判断
		ShopImageList page = shopService.findById(id);
		Map<String, TemplateModel> paramWrap = new HashMap<String, TemplateModel>(
				params);
		paramWrap.put("oneshopimagelist", DEFAULT_WRAPPER.wrap(page));
		Map<String, TemplateModel> origMap = DirectiveUtils
				.addParamsToVariable(env, paramWrap);
		if (body != null) {
			body.render(env.getOut());
		}
		DirectiveUtils.removeParamsFromVariable(env, paramWrap, origMap);

	}

	@Autowired
    ShopImageListService shopService;
}