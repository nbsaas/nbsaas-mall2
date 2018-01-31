package com.quhaodian.haodian.web.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

/**
 * 前台工具类
 */
public class FrontUtils {

	public static void format(HttpServletRequest request, ModelMap modelMap) {
		Enumeration<String> enumerations = request.getParameterNames();
		while (enumerations.hasMoreElements()) {
			String pname = enumerations.nextElement();
			modelMap.put(pname, request.getAttribute(pname));
		}
	}
	public static String urls(HttpServletRequest request) {
		
         StringBuffer buffer=new StringBuffer();
         Enumeration<String>   es=     request.getParameterNames();
         if(es!=null){
        	 while (es.hasMoreElements()) {
				String string = (String) es.nextElement();
				buffer.append(string);
				buffer.append("=");
				buffer.append(request.getParameter(string));
				if(es.hasMoreElements()){
					buffer.append("&");
				}
			}
         }
         return buffer.toString();
	}
	public static void format(HttpServletRequest request,
			ModelAndView modelAndView) {
		Enumeration<String> enumerations = request.getParameterNames();
		while (enumerations.hasMoreElements()) {
			String pname = enumerations.nextElement();
			modelAndView.addObject(pname, request.getParameter(pname));
		}
	}
    public static Timestamp parseTimestamp(String time){
    	Timestamp resutl=null;
    	try {
    		SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			Date date = format.parse(time);
			resutl=new Timestamp(date.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resutl;
    	
    }
    public static String getPath(String view){
    	String resutl=null;
    	resutl=theme+view;
		return resutl;
    	
    }
    public static String redirect(String path){
    	String resutl=null;
    	resutl="redirect:"+path;
		return resutl;
    	
    }
    private static String theme="theme/yelp/";
	public static String getTheme() {
		return theme;
	}

	public static void setTheme(String theme) {
		FrontUtils.theme = theme;
	}
}
