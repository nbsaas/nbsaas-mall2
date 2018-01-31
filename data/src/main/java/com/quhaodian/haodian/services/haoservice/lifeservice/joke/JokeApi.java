package com.quhaodian.haodian.services.haoservice.lifeservice.joke;

import java.io.IOException;
import java.util.List;

import com.ada.common.http.Connection;
import com.ada.common.http.HttpConnection;
import com.ada.common.http.Connection.Method;
import com.google.gson.Gson;

public class JokeApi {

	public static void main(String[] args) {
		int pagesize = 20;
		int page = 1;
		ContentList list = ContentList(1, 20);
		if (list != null) {
			List<JokeContent> js = list.getResult();
			for (JokeContent jokeContent : js) {
				System.out.println(jokeContent.getContent());
			}
		}
	}

	public static ImgList ImgList(int page, int pagesize) {
		ImgList list = null;
		String url = "http://apis.haoservice.com/lifeservice/Joke/ImgList";
		Connection con = HttpConnection.connect(url).method(Method.POST);
		con.data("key", "7e34907d3f56410d9577415ca4dcc452");
		con.data("pagesize", "" + pagesize);
		con.data("page", "" + page);
		try {
			String body = con.execute().body();
			Gson gson = new Gson();
			list = gson.fromJson(body, ImgList.class);
			System.out.println(list.getResult());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static ContentList ContentList(int page, int pagesize) {
		ContentList list = null;
		String url = "http://apis.haoservice.com/lifeservice/Joke/ContentList";
		Connection con = HttpConnection.connect(url).method(Method.POST);
		con.data("key", "7e34907d3f56410d9577415ca4dcc452");
		con.data("pagesize", "" + pagesize);
		con.data("page", "" + page);
		try {
			String body = con.execute().body();
			Gson gson = new Gson();
			list = gson.fromJson(body, ContentList.class);
			System.out.println(list.getResult());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

}
