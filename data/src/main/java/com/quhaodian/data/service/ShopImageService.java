package com.quhaodian.data.service;

import com.ada.data.core.Pagination;
import com.quhaodian.data.entity.ShopImage;


public interface ShopImageService {
	public Pagination getPage(int pageNo, int pageSize);

	public ShopImage findById(Long id);
	public ShopImage findById(Long id,int num);

	public ShopImage save(ShopImage bean);

	public ShopImage update(ShopImage bean);

	public ShopImage deleteById(Long id);
	
	public ShopImage[] deleteByIds(Long[] ids);
	
	public Pagination pageByShop(Long id,int pageNo, int pageSize);
	public Pagination page(int areaid,int catalog,int pageNo, int pageSize);

}