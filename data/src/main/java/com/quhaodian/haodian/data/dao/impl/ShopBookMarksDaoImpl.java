package com.quhaodian.haodian.data.dao.impl;

import com.quhaodian.haodian.data.dao.ShopBookMarksDao;
import com.quhaodian.haodian.data.entity.ShopBookMarks;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haoxuer.discover.data.core.BaseDaoImpl;
import com.haoxuer.discover.data.core.Pagination;

@Repository
public class ShopBookMarksDaoImpl extends BaseDaoImpl<ShopBookMarks, Long> implements ShopBookMarksDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public ShopBookMarks findById(Long id) {
		ShopBookMarks entity = get(id);
		return entity;
	}

	public ShopBookMarks save(ShopBookMarks bean) {
		getSession().save(bean);
		return bean;
	}

	public ShopBookMarks deleteById(Long id) {
		ShopBookMarks entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ShopBookMarks> getEntityClass() {
		return ShopBookMarks.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}