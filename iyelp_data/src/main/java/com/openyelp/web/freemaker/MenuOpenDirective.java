package com.openyelp.web.freemaker;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import com.openyelp.web.utils.DirectiveUtils;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * HTML文本提取并截断
 * 
 * 需要拦截器com.jeecms.common.web.ProcessTimeFilter支持
 */
public class MenuOpenDirective implements TemplateDirectiveModel {

	@SuppressWarnings("unchecked")
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		String ids = DirectiveUtils.getString("ids", params);
		String id = DirectiveUtils.getString("id", params);
		if (ids != null) {
			Writer out = env.getOut();
			String did = "," + id;
			if (ids.endsWith(did)) {
				out.append("active");
			} else if (ids.indexOf(id) > 0) {
				String[] idss = ids.split(",");
				for (String string : idss) {
					if (string.trim().equals(id.trim())) {
						out.append("active open hsub");
						break;
					}
				}

			} else {
			}
		}

	}
}
