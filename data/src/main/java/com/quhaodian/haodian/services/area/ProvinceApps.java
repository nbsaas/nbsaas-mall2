package com.quhaodian.haodian.services.area;

import java.io.IOException;
import java.util.List;

import com.quhaodian.data.page.Filter;
import com.quhaodian.user.utils.ListUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import com.quhaodian.area.data.entity.Area;
import com.quhaodian.area.data.service.AreaService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.quhaodian.haodian.data.apps.ObjectFactory;

public class ProvinceApps {
	public static final String TOWN="http://cdn.weather.hao.360.cn/sed_api_area_query.php?grade=town&_jsonp=loadTown&code=0804";
	public static final String TOWN1="http://cdn.weather.hao.360.cn/sed_api_area_query.php";

	public static void main(String[] args) throws IOException {
		provinces();
		citys();
		towns();
	}

	private static void addtown() throws IOException {
		Connection con = Jsoup
				.connect("http://cdn.weather.hao.360.cn/sed_api_area_query.php");
		con.data("code","0401");
		con.data("grade", "town");
		con.data("_jsonp", "loadTown");

		String body = con.execute().body();
		System.out.println(body);
		JsonParser jsonParser = new JsonParser();
		JsonElement jsonElement = jsonParser.parse(toJson(body));
		System.out.println(jsonElement);
		JsonArray arrays = jsonElement.getAsJsonArray();

		for (JsonElement jsonElement2 : arrays) {

			JsonArray arrays2 = jsonElement2.getAsJsonArray();
			String name = arrays2.get(0).getAsString();
			int id = arrays2.get(1).getAsInt();
			System.out.println("" + name + "  id:" + id);
		}
	}

	private static void adddowndatas(int pid) throws IOException {
		AreaService service = ObjectFactory.get().getBean("cityServiceImpl",AreaService.class);
		List<Area> citys =  service.list(0,1000, ListUtils.list(Filter.eq("parent.id",pid)),null);
		for (Area city : citys) {
			System.out.println(city.getName());
			
			String body = dd(city);
			while ( body==null) {
				body = dd(city);
			}
			
			System.out.println(body);
			JsonParser jsonParser = new JsonParser();
			JsonElement jsonElement = jsonParser.parse(toJson(body));
			System.out.println(jsonElement);
			JsonArray arrays = jsonElement.getAsJsonArray();

			for (JsonElement jsonElement2 : arrays) {

				JsonArray arrays2 = jsonElement2.getAsJsonArray();
				String name = arrays2.get(0).getAsString();
				int id = arrays2.get(1).getAsInt();
				Area town = new Area();
				town.setParent(city);
				town.setLevelInfo(4);
				town.setName(name);
				town.setId(id);
				try {
					service.save(town);

				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println("" + name + "  id:" + id);
			}
		}
	}

	private static String dd(Area city) {
		Connection con = Jsoup
				.connect("http://cdn.weather.hao.360.cn/sed_api_area_query.php");
		con.data("code", city.getId() < 1000 ? "0" + city.getId()
				+ "" : city.getId() + "");
		con.data("grade", "town");
		con.data("_jsonp", "loadTown");

		String body=null;
		try {
			body = con.execute().body();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return body;
	}

	private static void citys() {
		AreaService service = ObjectFactory.get().getBean(AreaService.class);


		List<Area> provinces = service.list(0,1000, ListUtils.list(Filter.eq("levelInfo",2)),null);
		for (Area province : provinces) {
			System.out.println(province.getName());

			try {
				String body = "";
				Connection con = Jsoup
						.connect("http://cdn.weather.hao.360.cn/sed_api_area_query.php");
//				con.data("code", province.getCode() < 10 ? "0" + province.getCode()
//						+ "" : province.getCode() + "");
				con.data("grade", "city");
				con.data("_jsonp", "loadCity");

				body = con.execute().body();
				System.out.println(toJson(body));
				JsonParser jsonParser = new JsonParser();
				JsonElement jsonElement = jsonParser.parse(toJson(body));
				System.out.println(jsonElement);
				JsonArray arrays = jsonElement.getAsJsonArray();

				for (JsonElement jsonElement2 : arrays) {

					JsonArray arrays2 = jsonElement2.getAsJsonArray();
					String name = arrays2.get(0).getAsString();
					int id = arrays2.get(1).getAsInt();
					Area city = new Area();
					city.setParent(province);
					city.setName(name);
					//city.setCode(id);
					city.setLevelInfo(3);
					service.save(city);
					System.out.println("" + name + "  id:" + id);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	private static void towns() {
		AreaService service = ObjectFactory.get().getBean(AreaService.class);


		List<Area> provinces = service.list(0,1000, ListUtils.list(Filter.eq("levelInfo",3)),null);
		for (Area province : provinces) {
			System.out.println(province.getName());

			try {
				Connection con = Jsoup
						.connect("http://cdn.weather.hao.360.cn/sed_api_area_query.php");
				//con.data("code", province.getCode() < 1000 ? "0" + province.getCode()
				//		+ "" : province.getCode() + "");
				con.data("grade", "town");
				con.data("_jsonp", "loadTown");

				String body = con.execute().body();
				System.out.println(body);
				JsonParser jsonParser = new JsonParser();
				JsonElement jsonElement = jsonParser.parse(toJson(body));
				System.out.println(jsonElement);
				JsonArray arrays = jsonElement.getAsJsonArray();

				for (JsonElement jsonElement2 : arrays) {

					JsonArray arrays2 = jsonElement2.getAsJsonArray();
					String name = arrays2.get(0).getAsString();
					int id = arrays2.get(1).getAsInt();
					Area city = new Area();
					city.setParent(province);
					city.setName(name);
					//city.setCode(id);
					city.setLevelInfo(4);
					service.save(city);
					System.out.println("" + name + "  id:" + id);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void provinces() {
		AreaService service = ObjectFactory.get().getBean(
				AreaService.class);
		try {
			String body = Jsoup
					.connect(
							"http://cdn.weather.hao.360.cn/sed_api_area_query.php?grade=province&_jsonp=loadProvince")
					.execute().body();
			System.out.println(toJson(body));
			JsonParser jsonParser = new JsonParser();
			JsonElement jsonElement = jsonParser.parse(toJson(body));
			System.out.println(jsonElement);
			JsonArray arrays = jsonElement.getAsJsonArray();

			for (JsonElement jsonElement2 : arrays) {

				JsonArray arrays2 = jsonElement2.getAsJsonArray();
				String name = arrays2.get(0).getAsString();
				int id = arrays2.get(1).getAsInt();
				Area area=new Area();
				area.setId(1);
				Area p = new Area();
				//p.setCode(id);
				p.setName(name);
				p.setLevelInfo(2);
				p.setParent(area);
				service.save(p);
				System.out.println("" + name + "  id:" + id);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String toJson(String jsonStr) {

		return jsonStr.substring(jsonStr.lastIndexOf("(") + 1,
				jsonStr.lastIndexOf(")"));
	}
}
