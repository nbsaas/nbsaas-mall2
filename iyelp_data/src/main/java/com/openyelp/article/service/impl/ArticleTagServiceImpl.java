package com.openyelp.article.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openyelp.article.dao.ArticleTagDao;
import com.openyelp.article.entity.ArticleTag;
import com.openyelp.article.service.ArticleTagService;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.core.Updater;

@Service
@Transactional
public class ArticleTagServiceImpl implements ArticleTagService {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public ArticleTag findById(Long id) {
		ArticleTag entity = dao.findById(id);
		return entity;
	}

    @Transactional
	public ArticleTag save(ArticleTag bean) {
		dao.save(bean);
		return bean;
	}

    @Transactional
	public ArticleTag update(ArticleTag bean) {
		Updater<ArticleTag> updater = new Updater<ArticleTag>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

    @Transactional
	public ArticleTag deleteById(Long id) {
		ArticleTag bean = dao.deleteById(id);
		return bean;
	}

    @Transactional	
	public ArticleTag[] deleteByIds(Long[] ids) {
		ArticleTag[] beans = new ArticleTag[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private ArticleTagDao dao;

	@Autowired
	public void setDao(ArticleTagDao dao) {
		this.dao = dao;
	}
}