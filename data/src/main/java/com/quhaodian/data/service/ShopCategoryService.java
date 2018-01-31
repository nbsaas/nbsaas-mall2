package com.quhaodian.data.service;

import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.page.Page;
import com.quhaodian.data.page.Pageable;
import com.quhaodian.data.entity.ShopCategory;
import com.quhaodian.data.shop.vo.ShopCatalog;

import java.util.List;


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