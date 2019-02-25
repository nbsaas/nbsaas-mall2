package com.quhaodian.haodian.data.apps;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Locale;

import com.haoxuer.discover.user.data.entity.Menu;
import com.haoxuer.discover.user.data.service.MenuService;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class MenuApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ddd();
	}

	private static void ddd() {
		MenuService userService = ObjectFactory.get()
				.getBean(MenuService.class);
		long time=System.currentTimeMillis();
		Menu menu = userService.findById(1);
		System.out.println(menu.getChildrens());
		;
		Configuration configuration=new Configuration(Configuration.getVersion());
		configuration.setEncoding(Locale.CHINA, "utf-8");
		
		try {
			File file=new File(MenuApps.class.getResource("/").getFile());
			configuration.setDirectoryForTemplateLoading(file);
			//square_bracket
			configuration.setTagSyntax(Configuration.SQUARE_BRACKET_TAG_SYNTAX);
			Template template=configuration.getTemplate("menu.ftl");
			HashMap<String, Object> dataModel=new HashMap<String, Object>();
			dataModel.put("menus", menu.getChildrens());
			dataModel.put("menu", menu);
			Writer out=new StringWriter();
			template.process(dataModel, out);
			System.out.println(out.toString());
			time=System.currentTimeMillis()-time;
			System.out.println(time);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void ff() {
		MenuService userService = ObjectFactory.get()
				.getBean(MenuService.class);
		long time = System.currentTimeMillis();
		Menu p = new Menu();
		// userService.save(p);
		p.setId(12);

		Menu c = new Menu();
		c.setParent(p);
		for (int i = 0; i < 10; i++) {
			c.setName("三级菜单" + i);
			userService.save(c);

		}
		time = System.currentTimeMillis() - time;

		System.out.println(time);
	}

}
