package com.openyelp.shiro.apps;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

public class Apps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// securityManager
		SecurityManager s = ObjectFactory.get().getBean(SecurityManager.class);
		System.out.println(s);
		SecurityUtils.setSecurityManager(s);
		Subject ss = SecurityUtils.getSubject();
		System.out.println(ss);
		if(ss.isAuthenticated()){
			System.out.println("is login");
		}
		UsernamePasswordToken token=new UsernamePasswordToken();
		token.setUsername("ada");
		token.setPassword("ada".toCharArray());
		ss.login(token);
		if(ss.isAuthenticated()){
			System.out.println("is login");
		}
		//System.out.println(Endecr);
	}

}
