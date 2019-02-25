package com.quhaodian.haodian.data.service;

import com.haoxuer.discover.data.core.Pagination;
import com.quhaodian.haodian.data.entity.ShopAttr;


public interface ShopAttrService {
	public Pagination getPage(int pageNo, int pageSize);

	public ShopAttr findById(Long id);

	public ShopAttr save(ShopAttr bean);

	public ShopAttr update(ShopAttr bean);

	public ShopAttr deleteById(Long id);
	
	public ShopAttr[] deleteByIds(Long[] ids);
}