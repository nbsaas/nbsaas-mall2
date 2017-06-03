package com.quhaodian.data.dao;


import com.ada.data.core.BaseDao;
import com.ada.data.core.Pagination;
import com.ada.data.core.Updater;
import com.quhaodian.data.entity.Comment;

public interface CommentDao extends BaseDao<Comment, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public Comment findById(Integer id);

	public Comment save(Comment bean);

	public Comment updateByUpdater(Updater<Comment> updater);

	public Comment deleteById(Integer id);
}