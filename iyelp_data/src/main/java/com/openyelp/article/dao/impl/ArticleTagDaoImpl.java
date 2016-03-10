package com.openyelp.article.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.openyelp.article.dao.ArticleTagDao;
import com.openyelp.article.entity.ArticleTag;
import com.ada.data.core.BaseDaoImpl;
import com.ada.data.core.Pagination;

@Repository
public class ArticleTagDaoImpl extends BaseDaoImpl<ArticleTag, Long> implements ArticleTagDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public ArticleTag findById(Long id) {
		ArticleTag entity = get(id);
		return entity;
	}

	public ArticleTag save(ArticleTag bean) {
		getSession().save(bean);
		return bean;
	}

	public ArticleTag deleteById(Long id) {
		ArticleTag entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ArticleTag> getEntityClass() {
		return ArticleTag.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}