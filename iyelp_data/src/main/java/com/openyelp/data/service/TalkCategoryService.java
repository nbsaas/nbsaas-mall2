package com.openyelp.data.service;

import java.util.List;

import com.openyelp.annotation.RestFul;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.entity.EventInfoCategory;
import com.openyelp.data.entity.TalkCategory;


@RestFul(api=TalkCategoryService.class,value="TalkCategoryService")
public interface TalkCategoryService {
	public Pagination getPage(int pageNo, int pageSize);

	public TalkCategory findById(Integer id);

	public List<TalkCategory> findByCity(Integer id);

	public TalkCategory save(TalkCategory bean);

	public TalkCategory update(TalkCategory bean);

	public TalkCategory deleteById(Integer id);

	public TalkCategory[] deleteByIds(Integer[] ids);

	public List<TalkCategory> findByPid(int id);
}