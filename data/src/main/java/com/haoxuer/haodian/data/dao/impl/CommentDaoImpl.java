package com.haoxuer.haodian.data.dao.impl;

import com.haoxuer.haodian.data.entity.Comment;
import com.haoxuer.haodian.data.dao.CommentDao;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.BaseDaoImpl;
import com.haoxuer.discover.data.core.Pagination;

@Repository
public class CommentDaoImpl extends BaseDaoImpl<Comment, Integer> implements CommentDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public Comment findById(Integer id) {
		Comment entity = get(id);
		return entity;
	}

	public Comment save(Comment bean) {
		getSession().save(bean);
		return bean;
	}

	public Comment deleteById(Integer id) {
		Comment entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Comment> getEntityClass() {
		return Comment.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}