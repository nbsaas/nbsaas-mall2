package com.haoxuer.haodian.apps;

import com.haoxuer.haodian.data.apps.ObjectFactory;
import com.haoxuer.haodian.data.entity.EntityContent;
import com.haoxuer.haodian.data.entity.ShopCategory;
import com.haoxuer.haodian.data.service.EntityContentService;
import com.haoxuer.imake.ChainMake;
import com.haoxuer.imake.template.hibernate.TemplateHibernateDir;
import com.haoxuer.imake.templates.adminlte.TemplateAdminLTE;
import com.haoxuer.haodian.services.haoservice.lifeservice.joke.ContentList;
import com.haoxuer.haodian.services.haoservice.lifeservice.joke.JokeApi;
import com.haoxuer.haodian.services.haoservice.lifeservice.joke.JokeContent;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Apps {

	public static void main(String[] args) {
		ChainMake make=	new ChainMake(TemplateAdminLTE.class, TemplateHibernateDir.class);
		make.setAction("com.quhaodian.haodian.actions.admin");
		File view=new File("E:\\mvnspace\\quhaodian\\web\\src\\main\\webapp\\WEB-INF\\ftl\\admin");
		make.setView(view);

		List<Class<?>> cs=new ArrayList<Class<?>>();
		cs.add(ShopCategory.class);

		make.setMenus("1,33,35");
		make.setDao(false);
		make.setService(false);
		make.setView(false);
		make.setAction(true);
		make.makes(cs);
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
