package com.openyelp.data.apps;

import com.openyelp.data.entity.UserInfo;
import com.openyelp.data.entity.UserRole;
import com.openyelp.data.service.UserService;

public class UserServiceApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserService userService = ObjectFactory.get().getBean(
				UserService.class);
		UserInfo m=new 	UserInfo();
		m.setUsername("ada");
		m.setEmail("f");
		m.setPassword("123456");
		m.setPlainPassword("123456");
		userService.save(m);
		
		UserRole bean=new UserRole();
		bean.setName("ada");
		//System.out.println(userService.addRole(2l, bean));;
//		m=userService.findById(1l);
//		System.out.println(m.getRoles());
//		RoleService roleService= ObjectFactory.get().getBean(
//				RoleService.class);
//		Role bean=new Role("admin");
//		bean.setDescription("adminer");
//		bean.setId(2l);
		//roleService.save(bean);
		//userService.addRole(m.getId(), bean);
	}

}
