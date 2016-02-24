package com.openyelp.data.service;

import java.util.List;

import com.openyelp.annotation.RestFul;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.entity.Area;


@RestFul(value="AreaService",api=AreaService.class)
public interface AreaService {
	public Pagination getPage(int pageNo, int pageSize);

	public Area findById(Integer id);

	public Area findByName(String name);
	public Area findByNames(String name);

	public List<Area> findByLevel(Integer id);


	public List<Area> findByParent(Integer id);
	public List<Area> findByChild(Integer id);
	public List<Area> findByTops(Integer id);

	public List<Area> findByHot(Integer id);

	public Area save(Area bean);

	public Area update(Area bean);

	public Area deleteById(Integer id);

	public Area[] deleteByIds(Integer[] ids);
	
	public Pagination pageByLevel(int level,int pageNo, int pageSize);
	
	
	/**
	 * 
	 * @param areaid
	 * @param level
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination pageByLevel(Integer areaid,int level,int pageNo, int pageSize);
	
	

	/**
	 * 查询某个状态下的城市
	 * @param level
	 * @param state
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination pageByLevelState(int level,int state,int pageNo, int pageSize);


}