package com.quhaodian.data.apps;

import com.quhaodian.data.entity.ShopTime;

public class ShopTimeApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShopTime time=new ShopTime();
		time.setWeek(2);
		time.setMinhour(8);
		time.setMaxhour(47);
		System.out.println(time.getWork());
	}

}