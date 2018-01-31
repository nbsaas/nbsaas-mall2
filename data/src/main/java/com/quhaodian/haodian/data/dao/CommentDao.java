package com.quhaodian.haodian.data.dao;


import com.quhaodian.data.core.BaseDao;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.core.Updater;
import com.quhaodian.haodian.data.entity.Comment;

public interface CommentDao extends BaseDao<Comment, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public Comment findById(Integer id);

	public Comment save(Comment bean);

	public Comment updateByUpdater(Updater<Comment> updater);

	public Comment deleteById(Integer id);
}