package com.ada.iyelp.apps;

import com.ada.user.entity.UserRole;
import com.ada.user.service.UserRoleService;

public class UserRoleServiceApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserRoleService userService = ObjectFactory.get().getBean(
				UserRoleService.class);
		UserRole m=new 	UserRole();
		m.setDescription("xx");
		m.setName("管理员");
		userService.save(m);
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
