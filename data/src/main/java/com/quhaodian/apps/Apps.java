package com.quhaodian.apps;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.quhaodian.data.apps.ObjectFactory;
import com.quhaodian.data.entity.EntityContent;
import com.quhaodian.data.service.EntityContentService;
import com.quhaodian.services.haoservice.lifeservice.joke.ContentList;
import com.quhaodian.services.haoservice.lifeservice.joke.JokeApi;
import com.quhaodian.services.haoservice.lifeservice.joke.JokeContent;

public class Apps {

	public static void main(String[] args) {
		System.out.printf(""+getFloatRound(4.8,3));
	}

	private static void sad() {
		Long id = new Long("-100");
		System.out.println(id);

		System.out.println(id < 0);
		System.out.println(id < 0l);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		try {
			Date data = dateFormat.parse("20150319");
			data.setHours(23);
			data.setMinutes(59);
			data.setSeconds(59);
			System.out.println(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static float getFloatRound(double sourceData,int a)
	{
		int i = (int) Math.round(sourceData*a);     //小数点后 a 位前移，并四舍五入
		float f2 = (float) (i/(float)a);        //还原小数点后 a 位
		return f2;
	}
	private static void ff() {
		EntityContentService s = ObjectFactory.get().getBean(
				EntityContentService.class);
		ContentList list = JokeApi.ContentList(1, 10);
		List<JokeContent> imgs = list.getResult();
		for (JokeContent jokeContent : imgs) {
			EntityContent e = new EntityContent();
			e.setContent(jokeContent.getContent());
			e.setType(jokeContent.getType());
			e.setTitle(jokeContent.getTitle());
			e.setUpdatetime(jokeContent.getUpdatetime());
			s.save(e);
		}
	}

}
