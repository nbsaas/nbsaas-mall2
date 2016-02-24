package com.openyelp.article.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openyelp.article.dao.ArticleCommentDao;
import com.openyelp.article.dao.ArticleDao;
import com.openyelp.article.entity.Article;
import com.openyelp.article.entity.ArticleComment;
import com.openyelp.article.page.ArticleCommentPage;
import com.openyelp.article.service.ArticleCommentService;
import com.openyelp.data.core.Finder;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;

@Service
@Transactional
public class ArticleCommentServiceImpl implements ArticleCommentService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public ArticleComment findById(Long id) {
		ArticleComment entity = dao.findById(id);
		return entity;
	}
	
	@Autowired
	ArticleDao articleDao;

    @Transactional
	public ArticleComment save(ArticleComment bean) {
    	if (bean.getArticle()!=null) {
        	Article article = articleDao.findById(bean.getArticle().getId());
        	if(article!=null){
        		Finder finder=Finder.create();
        		finder.append("from ArticleComment p where p.article.id =:articled");
        		finder.setParam("articled", article.getId());
        		int c=articleDao.countQueryResult(finder);
        		article.setComments(c);
        	}
    		dao.save(bean);
		}else{
			bean.setId(-1l);
		}
		return bean;
	}

    @Transactional
	public ArticleComment update(ArticleComment bean) {
		Updater<ArticleComment> updater = new Updater<ArticleComment>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public ArticleComment deleteById(Long id) {
		ArticleComment bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public ArticleComment[] deleteByIds(Long[] ids) {
		ArticleComment[] beans = new ArticleComment[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private ArticleCommentDao dao;

	@Autowired
	public void setDao(ArticleCommentDao dao) {
		this.dao = dao;
	}

	
	@Transactional(readOnly = true)
	@Override
	public ArticleCommentPage pageByArticle(Long articleid, int pageNo,
			int pageSize) {
		ArticleCommentPage result=null;
		
		Finder finder=Finder.create();
		finder.append("from ArticleComment a where a.article.id=:articleid");
		finder.setParam("articleid", articleid);
		finder.append("order by a.id desc ");
		Pagination<ArticleComment> cs=	dao.find(finder, pageNo, pageSize);
		result=new ArticleCommentPage(cs);
		return result;
	}
}