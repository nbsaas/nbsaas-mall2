package com.ada.common.freemarker;

import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.openyelp.web.utils.DirectiveUtils;
import com.openyelp.web.utils.StrUtils;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

public class DateTag implements TemplateDirectiveModel {

	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		// TODO Auto-generated method stub
		Date s = DirectiveUtils.getDate("date", params);
		String pattern=DirectiveUtils.getString("format", params);
		if(pattern==null||pattern.length()<3){
			pattern="yyyy-MM-dd";
		}
		if (s != null) {
			String render="";
			Date now=new Date();
			long time=now.getTime()-s.getTime();
			long day7=1000*60*60*24*7;
			long day=1000*60*60*24;
			long timeh=1000*60*60;
			long timem=1000*60*60;

			if(time<day7){
				long d=time/day;
				if(d>0){
					render=d+"天前";
				}else{
					 d=time/timeh;
					 if(d>0){
						 render=d+"小时前";
					 }else{
						 d=time/timem;
						 if(d>0){
							 render=d+"分钟前";
						 }else{
							 render="刚刚";
						 }
					 }
				}
				
			}else{
				SimpleDateFormat format=new SimpleDateFormat(pattern);
				render=format.format(s);
			}
			Writer out = env.getOut();
			out.append(render);
		}
	}

}
