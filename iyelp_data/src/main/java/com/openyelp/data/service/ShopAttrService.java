package com.openyelp.data.service;

import com.openyelp.annotation.RestFul;
import com.ada.data.core.Pagination;
import com.openyelp.data.entity.ShopAttr;



@RestFul(api=ShopAttrService.class,value="ShopAttrService")
public interface ShopAttrService {
	public Pagination getPage(int pageNo, int pageSize);

	public ShopAttr findById(Long id);

	public ShopAttr save(ShopAttr bean);

	public ShopAttr update(ShopAttr bean);

	public ShopAttr deleteById(Long id);
	
	public ShopAttr[] deleteByIds(Long[] ids);
}