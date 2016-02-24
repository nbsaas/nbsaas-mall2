package com.openyelp.data.service;

import java.util.List;

import com.openyelp.annotation.RestFul;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.entity.TalkCategory;
import com.openyelp.data.entity.TalkCategoryArea;
@RestFul(api=TalkCategoryAreaService.class,value="TalkCategoryAreaService")
public interface TalkCategoryAreaService {
	public Pagination getPage(int pageNo, int pageSize);

	public TalkCategoryArea findById(Integer id);
	public List<TalkCategoryArea> findByCity(Integer id);

	public TalkCategoryArea save(TalkCategoryArea bean);

	public TalkCategoryArea update(TalkCategoryArea bean);

	public TalkCategoryArea deleteById(Integer id);
	
	public TalkCategoryArea[] deleteByIds(Integer[] ids);
}