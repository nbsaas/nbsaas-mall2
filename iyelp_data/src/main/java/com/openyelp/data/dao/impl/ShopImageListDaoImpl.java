package com.openyelp.data.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ada.data.core.BaseDaoImpl;
import com.ada.data.core.Pagination;
import com.openyelp.data.dao.ShopImageListDao;
import com.openyelp.data.entity.ShopImageList;

@Repository
public class ShopImageListDaoImpl extends BaseDaoImpl<ShopImageList, Long> implements ShopImageListDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public ShopImageList findById(Long id) {
		ShopImageList entity = get(id);
		return entity;
	}

	public ShopImageList save(ShopImageList bean) {
		getSession().save(bean);
		return bean;
	}

	public ShopImageList deleteById(Long id) {
		ShopImageList entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ShopImageList> getEntityClass() {
		return ShopImageList.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}