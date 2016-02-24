package com.openyelp.data.dao;


import com.ada.data.core.BaseDao;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import  com.openyelp.data.entity.ShopCategory;

public interface ShopCategoryDao extends BaseDao<ShopCategory, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public ShopCategory findById(Integer id);

	public ShopCategory save(ShopCategory bean);

	public ShopCategory updateByUpdater(Updater<ShopCategory> updater);

	public ShopCategory deleteById(Integer id);
	
	
	/**
	 * 从子节点更新到根节点
	 * 
	 * @param id
	 *            子节点id
	 * @return 更新节点层数
	 */
	public Integer updateNums(Integer id);
	
	/**
	 * 从子节点更新到根节点
	 * 
	 * @param id
	 *            子节点id
	 * @return 更新节点层数
	 */
	public Integer updateNumsAndTime(Integer id);
}