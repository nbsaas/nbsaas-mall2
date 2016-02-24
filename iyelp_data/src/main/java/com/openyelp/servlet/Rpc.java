package com.openyelp.servlet;

import org.springframework.context.ApplicationContext;

import com.openyelp.data.apps.ObjectFactory;

public class Rpc extends RpcServlet {

	@Override
	public ApplicationContext getApplicationContext() {
		// TODO Auto-generated method stub
		return ObjectFactory.get();
	}

}

