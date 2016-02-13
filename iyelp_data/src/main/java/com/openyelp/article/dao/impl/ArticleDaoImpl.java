package com.openyelp.article.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.openyelp.article.dao.ArticleDao;
import com.openyelp.article.entity.Article;
import com.openyelp.data.core.BaseDaoImpl;
import com.openyelp.data.core.Pagination;

@Repository
public class ArticleDaoImpl extends BaseDaoImpl<Article, Long> implements ArticleDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public Article findById(Long id) {
		Article entity = get(id);
		return entity;
	}

	public Article save(Article bean) {
		getSession().save(bean);
		return bean;
	}

	public Article deleteById(Long id) {
		Article entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Article> getEntityClass() {
		return Article.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}