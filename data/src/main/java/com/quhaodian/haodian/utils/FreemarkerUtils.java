/*
 * 
 * 
 * 
 */
package com.quhaodian.haodian.utils;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * Utils - Freemarker
 * 
 * 
 * 
 */
@SuppressWarnings("unchecked")
public final class FreemarkerUtils {



	/**
	 * 不可实例化
	 */
	private FreemarkerUtils() {
	}

	/**
	 * 解析字符串模板
	 * 
	 * @param template
	 *            字符串模板
	 * @param model
	 *            数据
	 * @return 解析后内容
	 */
	public static String process(String template, Map<String, ?> model) throws IOException, TemplateException {
		Configuration configuration = null;
		ApplicationContext applicationContext = SpringUtils.getApplicationContext();
		if (applicationContext != null) {
			FreeMarkerConfigurer freeMarkerConfigurer=null;
//			try {
//				freeMarkerConfigurer = SpringUtils.getBean("freeMarkerConfigurer", FreeMarkerConfigurer.class);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			 
			if (freeMarkerConfigurer != null) {
				configuration = freeMarkerConfigurer.getConfiguration();
			}
		}
		return process(template, model, configuration);
	}

	/**
	 * 解析字符串模板
	 * 
	 * @param template
	 *            字符串模板
	 * @param model
	 *            数据
	 * @param configuration
	 *            配置
	 * @return 解析后内容
	 */
	public static String process(String template, Map<String, ?> model, Configuration configuration) throws IOException, TemplateException {
		if (template == null) {
			return null;
		}
		if (configuration == null) {
			configuration = new Configuration();
		}
		StringWriter out = new StringWriter();
		new Template("template", new StringReader(template), configuration).process(model, out);
		return out.toString();
	}

}