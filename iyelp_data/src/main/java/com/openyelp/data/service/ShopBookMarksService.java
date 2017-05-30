package com.openyelp.data.service;

import com.ada.data.core.Pagination;
import com.openyelp.data.entity.ShopBookMarks;



public interface ShopBookMarksService {
	public Pagination getPage(int pageNo, int pageSize);

	public ShopBookMarks findById(Long id);

	public ShopBookMarks save(ShopBookMarks bean);

	public ShopBookMarks update(ShopBookMarks bean);

	public ShopBookMarks deleteById(Long id);
	
	public ShopBookMarks[] deleteByIds(Long[] ids);
	
	public Pagination pageByUser(long uerid,int pageNo, int pageSize);

}