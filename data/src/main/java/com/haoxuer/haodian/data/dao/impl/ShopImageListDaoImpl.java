package com.haoxuer.haodian.data.dao.impl;

import com.haoxuer.haodian.data.entity.ShopImageList;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.BaseDaoImpl;
import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.haodian.data.dao.ShopImageListDao;

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