package com.openyelp.data.service;

import com.openyelp.annotation.RestFul;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.entity.Comment;



@RestFul(api=CommentService.class,value="CommentService")
public interface CommentService {
	public Pagination getPage(int pageNo, int pageSize);

	public Comment findById(Integer id);

	public Comment save(Comment bean);

	public Comment update(Comment bean);

	public Comment deleteById(Integer id);
	
	public Comment[] deleteByIds(Integer[] ids);
}