package com.openyelp.data.service;

import com.ada.data.core.Pagination;
import com.openyelp.data.entity.Comment;



public interface CommentService {
	public Pagination getPage(int pageNo, int pageSize);

	public Comment findById(Integer id);

	public Comment save(Comment bean);

	public Comment update(Comment bean);

	public Comment deleteById(Integer id);
	
	public Comment[] deleteByIds(Integer[] ids);
}