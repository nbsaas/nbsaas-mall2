package com.openyelp.data.dao;


import com.openyelp.data.core.BaseDao;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;
import com.openyelp.data.entity.Comment;

public interface CommentDao extends BaseDao<Comment, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public Comment findById(Integer id);

	public Comment save(Comment bean);

	public Comment updateByUpdater(Updater<Comment> updater);

	public Comment deleteById(Integer id);
}