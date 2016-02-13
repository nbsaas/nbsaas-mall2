package com.openyelp.data.service;

import java.util.List;

import com.openyelp.annotation.RestFul;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.entity.Shop;
import com.openyelp.data.entity.ShopCategory;

@RestFul(value="ShopService",api=ShopService.class)
public interface ShopService {
	public Pagination getPage(int pageNo, int pageSize);

	public Pagination page(int pageNo, int pageSize);
	public Pagination pageByNew(int areaid,int pageNo, int pageSize);

	public Pagination pageByNear(int shopid,int pageNo, int pageSize);
	public Pagination pageByGood(int shopid,int pageNo, int pageSize);
	public Pagination pageByType(int areaid,int catalog,int pageNo, int pageSize);

	public Pagination search(String loc,String find_desc,int pageNo, int pageSize);
	public Pagination search(String loc,String find_desc,int catalog,int pageNo, int pageSize);
	public Pagination search(String key,int areaid,int catalog,int pageNo, int pageSize);

	public List search(String hql);

	public Shop findById(Long id);

	public Shop save(Shop bean);
	
	public Shop findByRand(int  areaid);

	public Shop addTag(Shop bean,String tag);
	public Shop addCategory(Shop bean,ShopCategory category);
	public Shop addCategory(Shop bean,Integer category);

	
	public Shop deleteTag(Shop bean,String tag);

	public Shop update(Shop bean);

	public Shop deleteById(Long id);
	
	public Shop[] deleteByIds(Long[] ids);
}