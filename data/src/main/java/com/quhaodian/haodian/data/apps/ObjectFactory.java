package com.quhaodian.haodian.data.apps;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ObjectFactory {

	private static ApplicationContext applicationContext;

	public static ApplicationContext get() {
		if (applicationContext == null) {
			applicationContext = new ClassPathXmlApplicationContext(
					"applicationContext-area.xml");
		}
		return applicationContext;

	}

	public static Connection getConnection() {

		Connection conn = null;
		try {
			conn = ObjectFactory.get().getBean(DataSource.class)
					.getConnection();
		} catch (BeansException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}
}
