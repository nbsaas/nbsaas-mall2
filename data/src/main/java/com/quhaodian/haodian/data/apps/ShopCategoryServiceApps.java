package com.quhaodian.haodian.data.apps;

import java.util.List;

import com.quhaodian.haodian.data.entity.ShopCategory;
import com.quhaodian.haodian.data.service.ShopCategoryService;

public class ShopCategoryServiceApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShopCategoryService userService = ObjectFactory.get().getBean(
				ShopCategoryService.class);
//		Long time=System.currentTimeMillis();
//		List<ShopCatalog> cs=	userService.findByPidl2(1);
//		for (ShopCatalog shopCatalog : cs) {
//			//System.out.println(shopCatalog);
//		}
//		time=System.currentTimeMillis()-time;
//		System.out.println(time);
		
		System.out.println(userService.updateNumsAndTime(114));
	}

	private static void s() {
		ShopCategoryService userService = ObjectFactory.get().getBean(
				ShopCategoryService.class);
		ShopCategory m=new 	ShopCategory();
		m.setName("商家分类");
//		userService.save(m);
		List<ShopCategory>  cs=	userService.findByTops(537);
		for (ShopCategory shopCategory : cs) {
			System.out.println(shopCategory.getCname());
		}
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
