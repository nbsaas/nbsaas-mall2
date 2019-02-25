package com.quhaodian.haodian.data.service.impl;

import com.quhaodian.haodian.data.dao.CommentDao;
import com.quhaodian.haodian.data.entity.Comment;
import com.quhaodian.haodian.data.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.discover.data.core.Updater;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public Comment findById(Integer id) {
		Comment entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public Comment save(Comment bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public Comment update(Comment bean) {
		Updater<Comment> updater = new Updater<Comment>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public Comment deleteById(Integer id) {
		Comment bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public Comment[] deleteByIds(Integer[] ids) {
		Comment[] beans = new Comment[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private CommentDao dao;

	@Autowired
	public void setDao(CommentDao dao) {
		this.dao = dao;
	}
}