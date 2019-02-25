package com.haoxuer.haodian.data.dao;


import com.haoxuer.discover.data.core.BaseDao;
import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.discover.data.core.Updater;
import com.haoxuer.haodian.data.entity.Comment;

public interface CommentDao extends BaseDao<Comment, Integer>{
	public Pagination getPage(int pageNo, int pageSize);

	public Comment findById(Integer id);

	public Comment save(Comment bean);

	public Comment updateByUpdater(Updater<Comment> updater);

	public Comment deleteById(Integer id);
}