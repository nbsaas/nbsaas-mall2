package com.quhaodian.data.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quhaodian.data.core.BaseDaoImpl;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.data.dao.ShopAttrDao;
import com.quhaodian.data.entity.ShopAttr;

@Repository
public class ShopAttrDaoImpl extends BaseDaoImpl<ShopAttr, Long> implements ShopAttrDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public ShopAttr findById(Long id) {
		ShopAttr entity = get(id);
		return entity;
	}

	public ShopAttr save(ShopAttr bean) {
		getSession().save(bean);
		return bean;
	}

	public ShopAttr deleteById(Long id) {
		ShopAttr entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ShopAttr> getEntityClass() {
		return ShopAttr.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}