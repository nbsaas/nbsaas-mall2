package com.ada.common.freemarker;

import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import com.quhaodian.web.utils.DirectiveUtils;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

public class DateWeekTag implements TemplateDirectiveModel {

	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		// TODO Auto-generated method stub
		Date s = DirectiveUtils.getDate("date", params);
		String pattern = DirectiveUtils.getString("format", params);
		if (pattern == null || pattern.length() < 3) {
			pattern = "yyyy年MM月dd日";
		}
		if (s != null) {
			String render = "";
			try {
				final String dayNames[] = { "星期日", "星期一", "星期二", "星期三", "星期四",
						"星期五", "星期六" };

				SimpleDateFormat sdfInput = new SimpleDateFormat(pattern);

				Calendar calendar = Calendar.getInstance();

				calendar.setTime(s);
				int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
				render = dayNames[dayOfWeek - 1] + " " + sdfInput.format(s);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Writer out = env.getOut();
			out.append(render);
		}
	}

}
