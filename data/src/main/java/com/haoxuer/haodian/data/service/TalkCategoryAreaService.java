package com.haoxuer.haodian.data.service;

import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.haodian.data.entity.TalkCategoryArea;

import java.util.List;
public interface TalkCategoryAreaService {
	public Pagination getPage(int pageNo, int pageSize);

	public TalkCategoryArea findById(Integer id);
	public List<TalkCategoryArea> findByCity(Integer id);

	public TalkCategoryArea save(TalkCategoryArea bean);

	public TalkCategoryArea update(TalkCategoryArea bean);

	public TalkCategoryArea deleteById(Integer id);
	
	public TalkCategoryArea[] deleteByIds(Integer[] ids);
}