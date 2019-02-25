package com.haoxuer.haodian.data.service;

import com.haoxuer.haodian.data.entity.EventInfo;
import com.haoxuer.discover.data.core.Pagination;


public interface EventInfoService {
	public Pagination getPage(int pageNo, int pageSize);

	public EventInfo findById(Long id);
	public EventInfo view(Long id);

	public EventInfo save(EventInfo bean);

	public EventInfo update(EventInfo bean);

	public EventInfo deleteById(Long id);

	public EventInfo[] deleteByIds(Long[] ids);

	/**
	 * 最近添加的活动
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination pageByRecent(int pageNo, int pageSize);

	/**
	 * 最近添加的活动
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination pageByMe(long id, int pageNo, int pageSize);
	
	/**
	 * 最近添加的活动
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination pageByMeAdd(long id, int pageNo, int pageSize);
	
	/**
	 * 最近添加的活动
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination pageByJoin(long id,int type, int pageNo, int pageSize);
	
	/**
	 * 最近添加的活动
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination pageByNew(Integer areaid, int pageNo, int pageSize);

	/**
	 * 人气的活动  大于当前时间
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination pageByHot(Integer areaid,int pageNo, int pageSize);
	
	
	/**
	 * 人气的活动  一周内
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination pageByWeek(Integer areaid,int pageNo, int pageSize);
	
	
	
	/**
	 * 官方活动
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination pageByGov(Integer areaid,int pageNo, int pageSize);
	/**
	 * 置顶 活动
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination pageByTop(Integer areaid,int pageNo, int pageSize);

	public Pagination browse(Long id, String start_date, String end_date,
			String sort_by, Integer[] c, String[] audience, int curpage,
			int pagesize);

}