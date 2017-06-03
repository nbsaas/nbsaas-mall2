package com.quhaodian.data.apps;

import java.util.List;

import com.ada.data.core.Pagination;
import com.quhaodian.data.entity.Shop;
import com.quhaodian.data.entity.ShopTime;
import com.quhaodian.data.service.ShopService;

public class ShopServiceApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShopService userService = ObjectFactory.get()
				.getBean(ShopService.class);
		Shop shop = userService.findById(3431l);
		ShopTime value=new ShopTime();
		shop.getTimes().put(1, value);
		shop.getTimes().put(0, value);
		System.out.println(shop);
		shop = userService.update(shop);
		System.out.println(shop);
		// Pagination p = userService.search("",1,1, 1, 10);
		// System.out.println(p.getList());
		// p = userService.pageByType(1,1, 1, 10);
		// System.out.println(p.getList());
		// select * from(
		// select
		// shop0_.*
		// from
		// shop shop0_
		// inner join
		// shop_category_links categorys1_
		// on shop0_.id=categorys1_.shop_id
		// inner join
		// shop_category shopcatego2_
		// on categorys1_.categorys_id=shopcatego2_.id
		// where
		// shopcatego2_.lft>=1
		// and shopcatego2_.rgt<=10000) as xxx ,area where xxx.areaid=area.id
		// and area.lft >0 and area.rgt<1000
		// userService.search(" select distinct s from Shop s join s.categorys g where g.lft >0 and g.rgt<1000 and s.name like '%%' and s.area.lft > 0   ");
	}

	private static void ff() {
		ShopService userService = ObjectFactory.get()
				.getBean(ShopService.class);
		Pagination p = userService.search("重庆", "不", 1, 10);
		System.out.println(p);

		List ls = p.getList();
		for (Object object : ls) {
			System.out.println(object);
		}
		// m=userService.findById(1l);
		// System.out.println(m.getRoles());
		// RoleService roleService= ObjectFactory.get().getBean(
		// RoleService.class);
		// Role bean=new Role("admin");
		// bean.setDescription("adminer");
		// bean.setId(2l);
		// roleService.save(bean);
		// userService.addRole(m.getId(), bean);
	}

}
