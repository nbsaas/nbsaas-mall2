package com.quhaodian.apps;

import java.io.IOException;

import com.ada.common.http.Connection;
import com.ada.common.http.HttpConnection;

public class ClientApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 0; i < 100000; i++) {
			Connection connection = HttpConnection
					.connect("http://cng1985.sturgeon.mopaas.com/api/login.htm");
			connection.data("username", "admin");
			connection.data("password", "123456");
			connection.data("macaddress", "axx");
			try {
				String body = connection.execute().body();
				System.out.println(body);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
