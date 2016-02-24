package com.openyelp.article.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.openyelp.article.dao.ArticleCommentDao;
import com.openyelp.article.entity.ArticleComment;
import com.openyelp.data.core.BaseDaoImpl;
import com.openyelp.data.core.Pagination;

@Repository
public class ArticleCommentDaoImpl extends BaseDaoImpl<ArticleComment, Long> implements ArticleCommentDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public ArticleComment findById(Long id) {
		ArticleComment entity = get(id);
		return entity;
	}

	public ArticleComment save(ArticleComment bean) {
		getSession().save(bean);
		return bean;
	}

	public ArticleComment deleteById(Long id) {
		ArticleComment entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ArticleComment> getEntityClass() {
		return ArticleComment.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}