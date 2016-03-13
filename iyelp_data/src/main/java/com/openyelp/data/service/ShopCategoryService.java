package com.openyelp.data.service;

import java.util.List;

import com.ada.data.core.Pagination;
import com.ada.data.page.Page;
import com.ada.data.page.Pageable;
import com.openyelp.annotation.RestFul;
import com.openyelp.data.entity.ShopCategory;
import com.openyelp.data.entity.TalkCategory;
import com.openyelp.data.shop.vo.ShopCatalog;


@RestFul(api=ShopCategoryService.class,value="ShopCategoryService")
public interface ShopCategoryService {
	public Pagination getPage(int pageNo, int pageSize);

	public ShopCategory findById(Integer id);
	public ShopCategory findByName(String id);

	public ShopCategory save(ShopCategory bean);

	public ShopCategory update(ShopCategory bean);

	public ShopCategory deleteById(Integer id);
	
	public ShopCategory[] deleteByIds(Integer[] ids);

	public List<ShopCategory> findByPid(int id);
	
	public List<ShopCatalog> findByPidl2(int id);

	public List<ShopCatalog> findByPidl1(int id);

	
	public List<ShopCategory> findByTops(int id);

	public String  findByPidForJson(int id);
	
	public Pagination pageByNear(Long shopid,int pageNo, int pageSize);

	/**
	 * 
	 * @param id 分类id
	 * @return 根据级数
	 */
	public Integer updateNumsAndTime(Integer id);
	
	public Page<ShopCategory> findPage(Pageable pageable);

	public List<ShopCategory> findTop(int id);

}