package com.haoxuer.haodian.data.service;

import com.haoxuer.haodian.data.entity.ShopCategory;
import com.haoxuer.haodian.data.shop.vo.ShopCatalog;
import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.discover.data.page.Page;
import com.haoxuer.discover.data.page.Pageable;

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

    Page<ShopCategory> page(Pageable pageable);
}