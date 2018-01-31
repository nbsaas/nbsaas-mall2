package com.quhaodian.haodian.data.apps;

import com.quhaodian.haodian.data.entity.UserCity;
import com.quhaodian.user.data.entity.UserInfo;
import com.quhaodian.haodian.data.service.UserCityService;

public class UserCityServiceApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserCityService userService = ObjectFactory.get().getBean(
				UserCityService.class);
		UserInfo m=new 	UserInfo();
		m.setId(1L);
		UserCity city=new UserCity();
		city.setUser(m);
		city.setName("ada");
		city.setAddress("西安市高新一路");
		userService.save(city);
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
