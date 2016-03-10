package com.openyelp.data.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.BaseDaoImpl;
import com.ada.data.core.Pagination;
import com.openyelp.data.dao.ShopReviewListItemDao;
import com.openyelp.data.entity.ShopReviewListItem;

@Repository
public class ShopReviewListItemDaoImpl extends BaseDaoImpl<ShopReviewListItem, Long> implements ShopReviewListItemDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public ShopReviewListItem findById(Long id) {
		ShopReviewListItem entity = get(id);
		return entity;
	}

	public ShopReviewListItem save(ShopReviewListItem bean) {
		getSession().save(bean);
		return bean;
	}

	public ShopReviewListItem deleteById(Long id) {
		ShopReviewListItem entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ShopReviewListItem> getEntityClass() {
		return ShopReviewListItem.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}