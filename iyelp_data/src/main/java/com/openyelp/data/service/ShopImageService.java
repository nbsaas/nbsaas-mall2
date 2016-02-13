package com.openyelp.data.service;

import com.openyelp.annotation.RestFul;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.entity.ShopImage;




@RestFul(api=ShopImageService.class,value="ShopImageService")
public interface ShopImageService {
	public Pagination getPage(int pageNo, int pageSize);

	public ShopImage findById(Long id);
	public ShopImage findById(Long id,int num);

	public ShopImage save(ShopImage bean);

	public ShopImage update(ShopImage bean);

	public ShopImage deleteById(Long id);
	
	public ShopImage[] deleteByIds(Long[] ids);
	
	public Pagination pageByShop(Long id,int pageNo, int pageSize);
	public Pagination page(int areaid,int catalog,int pageNo, int pageSize);

}