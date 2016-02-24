package com.openyelp.data.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.openyelp.data.core.BaseDaoImpl;
import com.openyelp.data.core.Pagination;
import com.openyelp.data.dao.MenuDao;
import com.openyelp.data.entity.Menu;

@Repository
public class MenuDaoImpl extends BaseDaoImpl<Menu, Integer> implements MenuDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public Menu findById(Integer id) {
		Menu entity = get(id);
		return entity;
	}

	public Menu save(Menu bean) {
		getSession().save(bean);
		return bean;
	}

	public Menu deleteById(Integer id) {
		Menu entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<Menu> getEntityClass() {
		return Menu.class;
	}
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
	    super.setSessionFactory(sessionFactory);
	}
}