package com.haoxuer.haodian.data.dao;


import com.haoxuer.haodian.data.entity.ShopCategory;
import com.haoxuer.discover.data.core.CriteriaDao;
import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.discover.data.core.Updater;

public interface ShopCategoryDao extends CriteriaDao<ShopCategory, Integer>{
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