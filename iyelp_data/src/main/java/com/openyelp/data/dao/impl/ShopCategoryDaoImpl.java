package com.openyelp.data.dao.impl;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.article.entity.ArticleCatalog;
import com.ada.data.core.BaseDaoImpl;
import com.ada.data.core.Finder;
import com.ada.data.core.Pagination;
import com.openyelp.data.dao.ShopCategoryDao;
import com.openyelp.data.entity.ShopCategory;

@Repository
public class ShopCategoryDaoImpl extends BaseDaoImpl<ShopCategory, Integer> implements ShopCategoryDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		com.ada.data.core.Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public ShopCategory findById(Integer id) {
		ShopCategory entity = get(id);
		return entity;
	}

	public ShopCategory save(ShopCategory bean) {
		getSession().save(bean);
		return bean;
	}

	public ShopCategory deleteById(Integer id) {
		ShopCategory entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ShopCategory> getEntityClass() {
		return ShopCategory.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
	
	@Override
	public Integer updateNums(Integer id) {

		Integer result = 0;
		ShopCategory cur = findById(id);
		do {
			counts(cur);
			cur = cur.getParent();
			result++;
		} while (cur != null);

		return result;
	}
	private void counts(ShopCategory cur) {
		Finder finder = Finder.create();
		finder.append("from Shop a join  a.categorys as r where  r.lft >= :lft ");
		finder.setParam("lft", cur.getLft());
		finder.append(" and r.rgt <= :rgt");
		finder.setParam("rgt", cur.getRgt());
		Long size = countQuery(finder);
		cur.setNums(size);
	}

	@Override
	public Integer updateNumsAndTime(Integer id) {
		Integer result = 0;
		ShopCategory cur = findById(id);
		if (cur == null) {
			return result;
		}
		do {
			counts(cur);
			cur.setLastDate(new Date());
			cur = cur.getParent();
			result++;
		} while (cur != null);

		return result;
	}
}