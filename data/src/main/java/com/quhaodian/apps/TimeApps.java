package com.quhaodian.apps;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeApps {

	public static void main(String[] args) throws ParseException {
		System.out.println(1000*60*60*24);
		Date now=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date s=format.parse("2015-01-01 11:02:24");
		String render = null;
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
			
		}
		System.out.println(render);
	}

}
